	contract Restaurante {
		enum Cliente { C1, C2 }
		
		enum Prato  { Pizza, Pasta }
		
		struct Comanda {
			Cliente c;
			Prato   p;
		}
		
		mapping(Cliente => uint256) public clientesEsperando;
		mapping(Prato => uint256) public pedidoCliente;
		mapping(uint8 => mapping(uint8 => uint256)) public pedidosParaCozinha;
		mapping(uint8 => mapping(uint8 => uint256)) public pratosNoBalcao;
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
			require(pedidoCliente    >= 1, "PedidoCliente: marca ausente");
			
			clientesEsperando[c] -= 1;
			pedidoCliente[p]     -= 1;
			
			pedidosParaCozinha[uint8(c)][uint8(p)] += 1;
			
			emit FazerPedidoDisparada(c, p);
		}
		
		function cozinhar(Cliente c, Prato p) external {
			require(
			pedidosParaCozinha[uint8(c)][uint8(p)] >= 1,
			"PedidosParaCozinha: comanda ausente"
			);
			
			pedidosParaCozinha[uint8(c)][uint8(p)] -= 1;
			pratosNoBalcao[uint8(c)][uint8(p)]     += 1;
			
			emit CozinharDisparada(c, p);
		}
		
		function entregarPedido(Cliente c, Prato p) external {
			require(
			pratosNoBalcao[uint8(c)][uint8(p)] >= 1,
			"PratosNoBalcao: prato ausente"
			);
			
			pratosNoBalcao[uint8(c)][uint8(p)] -= 1;
			clientesSatisfeitos[c]             += 1;
			
			emit EntregarPedidoDisparada(c, p);
		}
	}