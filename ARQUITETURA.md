# Arquitetura do Tradutor Solidity → RPC (Redes de Petri Coloridas)

## Visão Geral

Este projeto implementa um tradutor sistemático que converte Smart Contracts em Solidity para modelos formais em Redes de Petri Coloridas (RPC), seguindo a metodologia descrita no documento de referência.

## Duas Fases de Processamento

### **Fase 1: Análise Sintática e Semântica (Algoritmo 2)**

A Fase 1 utiliza ANTLR4 para extrair metadados estruturados do código Solidity:

```
Arquivo .sol → Lexer ANTLR → Parser ANTLR → AST → Visitor → ListasInfo
```

#### Componentes:

1. **SolidityLexer.g4** - Gramática do Lexer (tokenização)
2. **SolidityParser.g4** - Gramática do Parser (análise sintática)
3. **SolidityVisitor** - Implementação do padrão Visitor que:
   - Extrai variáveis globais (nome, tipo, visibilidade, valor inicial)
   - Extrai funções (nome, parâmetros, retornos, visibilidade, modificadores)
   - Extrai operações (atribuições, incrementos, decrementos)
   - Extrai chamadas de função
   - Extrai condicionais (require, assert, if)

#### Saída:

**ListasInfo** - Agregador de metadados contendo:
```
- List<VariavelGlobal>   → variáveis de estado
- List<FuncaoSolidity>    → funções do contrato
- List<OperacaoSolidity>  → operações dentro das funções
- List<ChamadaFuncao>     → invocações de subfunções
- List<Condicional>       → validações e controle de fluxo
```

### **Fase 2: Mapeamento para Rede de Petri Colorida (Algoritmo 3)**

A Fase 2 transforma o `ListasInfo` em componentes topológicos da RPC:

```
ListasInfo → RPCBuilder → Lugares, Transições, Arcos → RPC Formal
```

#### Regras de Transformação:

##### **1. Instanciação de Lugares**

**Variáveis de Estado:**
- Cada variável global → 1 Lugar
- Tipo da variável → Color Set
- Valor inicial → Marcação inicial

Exemplo:
```solidity
uint256 public balance = 100;
```
Mapeado para:
```
Lugar {
  id: "lugar_var_0",
  name: "balance",
  colorSet: "UINT",
  initialMarking: "100"
}
```

**Lugares Oráculos:**
- Criados para funções `public` e `external` com parâmetros
- Nomenclatura: `par-<nomeFuncao>`
- Representam dados de entrada da blockchain

Exemplo:
```solidity
function deposit(uint256 amount) public { ... }
```
Mapeado para:
```
Lugar Oracle {
  id: "lugar_oracle_0",
  name: "par-deposit",
  colorSet: "UINT",
  isOracle: true
}
```

##### **2. Instanciação de Transições**

- Cada função → 1 Transição
- Modificadores (`onlyOwner`) → parte da expressão de Guarda
- Comandos `require` e `assert` → expressões de Guarda booleanas

Exemplo:
```solidity
function withdraw(uint256 amount) public {
  require(amount > 0);
  require(msg.sender == owner);
  balance -= amount;
}
```
Mapeado para:
```
Transição {
  id: "trans_1",
  name: "withdraw",
  guard: "amount>0 AND msg.sender==owner"
}
```

##### **3. Instanciação de Arcos**

**Fluxo Duplo para Variáveis de Estado:**
- Leitura: `Lugar → Transição`
- Escrita: `Transição → Lugar`
- Expressão de arco: tipo da variável (ColorSet)

Exemplo:
```
Arco {
  id: "arco_0",
  sourceId: "lugar_var_0",      // balance
  targetId: "trans_1",           // withdraw
  expression: "UINT"            // ColorSet
}
Arco {
  id: "arco_1",
  sourceId: "trans_1",           // withdraw
  targetId: "lugar_var_0",      // balance
  expression: "UINT"
}
```

**Arcos de Parâmetros:**
- Lugar Oracle → Transição correspondente
- Implementa a passagem de argumentos externos

**Arcos de Chamadas:**
- Transição chamadora → Lugar Oracle da função alvo
- Simula a invocação de subfunções

## Estrutura de Classes

### Modelos de Dados (Solidity)

- **VariavelGlobal** - Representação de variáveis de estado
- **FuncaoSolidity** - Representação de funções com metadados
- **OperacaoSolidity** - Representação de operações (assignments, cálculos)
- **ChamadaFuncao** - Representação de invocações de funções
- **Condicional** - Representação de `require`, `assert`, `if`
- **ListasInfo** - Agregador central de metadados

### Modelos de Redes de Petri (CPN)

- **Lugar** - Nó de armazenamento com ColorSet e marcação inicial
- **Transicao** - Nó de processamento com expressão de guarda
- **Arco** - Conexão entre Lugar e Transição com expressão SML

### Orquestração

- **SolidityVisitor** - Implementação do padrão Visitor para AST
- **RPCBuilder** - Builder que constrói a RPC a partir de ListasInfo
- **App** - Classe principal que orquestra o pipeline completo

## Fluxo de Execução

```
1. App.main(arquivo.sol)
   ↓
2. CharStream → SolidityLexer → SolidityParser
   ↓
3. ParseTree (AST)
   ↓
4. SolidityVisitor.visit(ParseTree) → ListasInfo
   ↓
5. ListasInfo.exibirResumo() [Fase 1]
   ↓
6. RPCBuilder.construirRPC(ListasInfo)
   ├→ criarLugaresVariaveis()
   ├→ criarLugaresOraculos()
   ├→ criarTransicoesFuncoes()
   ├→ criarArcosFluxoDados()
   └→ criarArcosCondicionais()
   ↓
7. RPCBuilder.exibirResultados() [Fase 2]
```

## Como Usar

### Compilação

```bash
cd /home/muriloneves/www/projetos/ic/parser-sol-rdp
mvn clean compile
```

### Execução

```bash
mvn exec:java -Dexec.mainClass="sol_rdp.App" -Dexec.args="exemplos/SimpleContract.sol"
```

### Saída Esperada

**Fase 1:**
- Resumo das Variáveis Globais
- Resumo das Funções
- Resumo das Operações
- Resumo das Chamadas
- Resumo dos Condicionais

**Fase 2:**
- Lugares (com IDs, nomes, color sets, marcação inicial)
- Transições (com IDs, nomes, guardas)
- Arcos (com IDs, source, target, expressão)

## Exemplo Prático

### Código Solidity

```solidity
pragma solidity ^0.8.0;

contract SimpleContract {
    uint256 public balance;
    
    function deposit(uint256 amount) public {
        require(amount > 0);
        balance += amount;
    }
}
```

### Fase 1 - Metadados Extraídos

```
Variáveis Globais:
  - balance (type: uint256, visibility: public, initial: "")

Funções:
  - deposit (visibility: public, parameters: {amount: uint256})

Operações:
  - balance += amount (in deposit)

Condicionais:
  - require(amount > 0) (in deposit)
```

### Fase 2 - RPC Gerada

```
LUGARES:
  - id: lugar_var_0
    name: balance
    colorSet: UINT
    initialMarking: ""
    
  - id: lugar_oracle_0
    name: par-deposit
    colorSet: UINT
    isOracle: true

TRANSIÇÕES:
  - id: trans_0
    name: deposit
    guard: "amount>0"

ARCOS:
  - id: arco_0, source: lugar_var_0, target: trans_0, expr: UINT
  - id: arco_1, source: trans_0, target: lugar_var_0, expr: UINT
  - id: arco_2, source: lugar_oracle_0, target: trans_0, expr: UINT
```

## Mapeamento de Tipos Solidity → ColorSet

| Solidity | ColorSet |
|----------|----------|
| `uint*` | `UINT` |
| `int*` | `INT` |
| `bool` | `BOOL` |
| `address` | `ADDRESS` |
| `string` | `STRING` |
| `mapping` | `MAPPING` |
| `type[]` | `ARRAY` |
| Customizados | `<TIPO_CUSTOM>` |

## Limitações e Escopos

### Implementados

✓ Extração de variáveis globais  
✓ Extração de funções e modificadores  
✓ Extração de operações e atribuições  
✓ Extração de chamadas de função  
✓ Extração de condicionais (require, assert)  
✓ Criação de Lugares e Transições  
✓ Mapeamento de Guards  
✓ Criação de Arcos duplos para variáveis de estado  

### Não Implementados (Escopo Futuro)

- Mapeamento de `revert` (requer sub-redes especializadas)
- Análise profunda de `enums` e `structs` como tipos customizados
- Rastreamento de fluxo de controle complexo (loops, switch)
- Verificação de overflow/underflow
- Detecção de vulnerabilidades (reentrancy, etc)

## Extensões Futuras

1. **Parser Melhorado:** Aumentar precisão da extração visitando nós específicos da AST
2. **Suporte a Structs:** Mapear estruturas customizadas como product color sets
3. **Suporte a Enums:** Mapear enumerações como finite color sets
4. **Análise de Fluxo:** Rastrear dependências entre variáveis
5. **Verificação Formal:** Executar modelo-checking na RPC gerada
6. **Exportação:** Gerar formato PNML (Petri Net Markup Language)

## Referências

- **Documento Base:** `ref/main-texto.pdf`
- **Especificação Técnica:** `.spec/Especificacao_Solidity_RPC.md`
- **ANTLR4:** https://www.antlr.org/
- **Solidity Grammar:** Community-maintained grammar based on official spec
- **Redes de Petri Coloridas:** Teoria de PN + Extensão de cores para domains

## Autor

Implementação da arquitetura conforme descrição metodológica - 2026
