pragma solidity ^0.8.0;

contract Restaurante {
    enum Cliente { C1, C2 }
    enum Prato  { Pizza, Pasta }
    
    struct Comanda {
        Cliente c;
        Prato   p;
    }
    
    mapping(Cliente => uint256) public clientesEsperando;
    mapping(Prato => uint256) public pedidoCliente;
    
    // Redes de Petri: Lugares explícitos com Σ = COMANDA
    Comanda[] public pedidosParaCozinha;
    Comanda[] public pratosNoBalcao;
    
    mapping(Cliente => uint256) public clientesSatisfeitos;
    
    event FazerPedidoDisparada(Cliente c, Prato p);
    event CozinharDisparada(Cliente c, Prato p);
    event EntregarPedidoDisparada(Cliente c, Prato p);
    
    constructor() {
        clientesEsperando[Cliente.C1] = 1;
        clientesEsperando[Cliente.C2] = 1;
        pedidoCliente[Prato.Pizza]    = 1;
    }
    
    function fazerPedido(Cliente c, Prato p) external {
        require(clientesEsperando[c] >= 1, "ClientesEsperando: marca ausente");
        require(pedidoCliente[p] >= 1, "PedidoCliente: marca ausente");
        
        clientesEsperando[c] -= 1;
        pedidoCliente[p]     -= 1;
        
        // Transição injetando o token 1'(c,p) no lugar "Pedidos p/ Cozinha"
        pedidosParaCozinha.push(Comanda(c, p));
        
        emit FazerPedidoDisparada(c, p);
    }
    
    function cozinhar(Cliente c, Prato p) external {
        uint256 index = type(uint256).max;
        
        // Simulação da busca do token exato no multiset
        for (uint256 i = 0; i < pedidosParaCozinha.length; i++) {
            if (pedidosParaCozinha[i].c == c && pedidosParaCozinha[i].p == p) {
                index = i;
                break;
            }
        }
        require(index != type(uint256).max, "PedidosParaCozinha: comanda ausente");
        
        // Consome o token da cozinha
        pedidosParaCozinha[index] = pedidosParaCozinha[pedidosParaCozinha.length - 1];
        pedidosParaCozinha.pop();
        
        // Injeta o token no balcão
        pratosNoBalcao.push(Comanda(c, p));
        
        emit CozinharDisparada(c, p);
    }
    
    function entregarPedido(Cliente c, Prato p) external {
        uint256 index = type(uint256).max;
        
        for (uint256 i = 0; i < pratosNoBalcao.length; i++) {
            if (pratosNoBalcao[i].c == c && pratosNoBalcao[i].p == p) {
                index = i;
                break;
            }
        }
        require(index != type(uint256).max, "PratosNoBalcao: prato ausente");
        
        // Consome o token do balcão
        pratosNoBalcao[index] = pratosNoBalcao[pratosNoBalcao.length - 1];
        pratosNoBalcao.pop();
        
        // Produz o token 1'c no lugar Clientes Satisfeitos
        clientesSatisfeitos[c] += 1;
        
        emit EntregarPedidoDisparada(c, p);
    }
}