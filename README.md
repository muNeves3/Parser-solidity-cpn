# Parser Solidity → RPC

Projeto em Java que lê contratos Solidity, extrai metadados do contrato e gera uma representação em **Rede de Petri Colorida (RPC)**.

## O que o projeto faz

O fluxo é dividido em duas fases:

1. **Análise do Solidity**
   - identifica contrato, variáveis globais, funções, operações, chamadas e condicionais;
2. **Construção da RPC**
   - transforma os dados extraídos em lugares, transições e arcos.

## Fluxo geral

```text
arquivo .sol
  → ANTLR Lexer
  → ANTLR Parser
  → Parse Tree
  → SolidityVisitor
  → ListasInfo
  → RPCBuilder
  → RPC final
```

## Como o código está organizado

```text
src/main/java/sol_rdp/
├── App.java              # ponto de entrada
├── visitor/
│   └── SolidityVisitor.java
├── rpc/
│   └── RPCBuilder.java
├── solidity/
│   ├── ListasInfo.java
│   ├── VariavelGlobal.java
│   ├── FuncaoSolidity.java
│   ├── OperacaoSolidity.java
│   ├── ChamadaFuncao.java
│   └── Condicional.java
└── cpn/
    ├── Lugar.java
    ├── Transicao.java
    └── Arco.java
```

## Fase 1: análise do contrato

O `SolidityVisitor` percorre a árvore sintática e monta um `ListasInfo`, que funciona como repositório central da análise.

Ele extrai:

- **variáveis globais**: nome, tipo, visibilidade e valor inicial;
- **funções**: nome, parâmetros, visibilidade, modificadores e se é construtor;
- **operações**: atribuições como `=`, `+=`, `-=`, inclusive em destinos indexados;
- **chamadas**: invocações simples dentro do corpo da função;
- **condicionais**: `require`, `assert` e outras validações.

### Observação importante

O parser foi ajustado para analisar **apenas o corpo** da função, não a assinatura inteira. Isso reduz falsos positivos e melhora a captura de operações reais do contrato.

## Fase 2: construção da RPC

O `RPCBuilder` converte o conteúdo de `ListasInfo` em elementos da rede:

- cada variável global vira um **Lugar**;
- cada função vira uma **Transição**;
- funções `public` e `external` com parâmetros ganham **Lugares Oráculos**;
- operações e variáveis usadas em condicionais geram **arcos de fluxo**;
- `require` e `assert` entram como parte da **guarda** da transição.

## Exemplo de uso

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass=sol_rdp.App -Dexec.args=exemplos/Restaurante.sol
```

## Exemplo de entrada

```solidity
function fazerPedido(Cliente c, Prato p) external {
    require(clientesEsperando[c] >= 1);
    clientesEsperando[c] -= 1;
    pedidosParaCozinha[uint8(c)][uint8(p)] += 1;
}
```

## Saída esperada

Na fase de análise, o projeto imprime:

- resumo das variáveis globais;
- resumo das funções;
- resumo das operações;
- resumo das chamadas;
- resumo das condicionais.

Na fase de RPC, imprime:

- lugares criados;
- transições criadas;
- arcos criados.

## Limitações atuais

- a extração ainda é baseada em regex em alguns pontos;
- chamadas e expressões muito complexas podem gerar ruído;
- o foco atual é em contratos com padrões mais diretos de operação e validação.

## Requisitos

- Java 8+
- Maven

## Comando principal

```bash
mvn exec:java -Dexec.mainClass=sol_rdp.App -Dexec.args=<arquivo.sol>
```

