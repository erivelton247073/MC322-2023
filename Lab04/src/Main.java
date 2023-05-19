import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Seguradora> lista_seguradora = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	
	//exibir menu externo
	private static void exibirMenuExterno() {
		MenuOpcoes menuOpcoes[] = MenuOpcoes.values();
		System.out.println("Menu principal");
		for(MenuOpcoes op: menuOpcoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}
	
	/* exibir submenus
	 * se a lista de constantes do submenu for percorrida da mesma forma que o meu externo, a opção Voltar
	 * é printada com a posição que está na lista do enum (9 - Voltar). Por isso, a lista é percorrida 
	 * de forma diferente, tendo i como o inteiro correspondente. Assim, para listar o submenu de cadastros,
	 * por exemplo, vai ser printado "3 - Voltar".
	 */
	private static void exibirSubmenu(MenuOpcoes op) {
		SubmenuOpcoes[] submenu = op.getSubmenu();
		System.out.println(op.getDescricao());
		for(int i=0; i<submenu.length; i++) {
			System.out.println(i +" - " + submenu[i].getDescricao());
		}
	}
	
	//ler opções do menu externo
	private static MenuOpcoes lerOpcaoMenuExterno() {
		int opUsuario;
		MenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > MenuOpcoes.values().length - 1);
		opUsuarioConst = MenuOpcoes.values()[opUsuario];
		return opUsuarioConst;
	}
	
	//ler opção dos submenus
	private static SubmenuOpcoes lerOpcaoSubmenu(MenuOpcoes op) {
		int opUsuario;
		SubmenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
		opUsuarioConst = op.getSubmenu()[opUsuario];
		return opUsuarioConst;
	}
	
	//executar opções do menu externo
	private static void executarOpcaoMenuExterno(MenuOpcoes op) {
		String nome_seguradora, nomeCliente1, nomeCliente2, placa, endereco;
		int anoNascimento, mesNascimento, diaNascimento;
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op);
				break;
			case GERAR_SINISTRO:
				System.out.println("Digite o nome da Segura:");
				nome_seguradora = scanner.nextLine();
				nome_seguradora = scanner.nextLine();
				System.out.println("Digite o nome do cliente responsavel pelo sinistro:");
                nomeCliente1 = scanner.nextLine();
                System.out.println("Digite a placa do carro:");
                placa = scanner.nextLine();
                System.out.println("Digite o endereco do sinistro:");
                endereco = scanner.nextLine();
                System.out.println("Digite o ano, o mes e o dia, respectivamente, sempre dando enter após cada um:");
                anoNascimento = scanner.nextInt();
                mesNascimento = scanner.nextInt();
                diaNascimento = scanner.nextInt();
				for (int i = 0; i < lista_seguradora.size(); i++){
					if (lista_seguradora.get(i).getNome().equals(nome_seguradora)==true){
						lista_seguradora.get(i).gerarSinistro(nomeCliente1, placa, endereco, anoNascimento, mesNascimento, diaNascimento);
						lista_seguradora.get(i).calcularPrecoSeguraCliente(nomeCliente1);
					}
				}
				break;
			case TRANSFERIR_SEGURO:
				System.out.println("Digite o nome da Segura:");
				nome_seguradora = scanner.nextLine();
				nome_seguradora = scanner.nextLine();
				System.out.println("Digite o nome do cliente que vai trasferir o seguro:");
				nomeCliente1 = scanner.nextLine();
				System.out.println("Digite o nome do cliente que vai receber o seguro:");
				nomeCliente2 = scanner.nextLine();
				for (int i = 0; i < lista_seguradora.size(); i++){
					if (lista_seguradora.get(i).getNome().equals(nome_seguradora)==true){
						lista_seguradora.get(i).transfereSeguro(nomeCliente1, nomeCliente2);
					}
				}
				break;
			case CALCULAR_RECEITA:
			System.out.println("Digite o nome da Segura:");
			nome_seguradora = scanner.nextLine();
			nome_seguradora = scanner.nextLine();
			for (int i = 0; i < lista_seguradora.size(); i++){
				if (lista_seguradora.get(i).getNome().equals(nome_seguradora)==true){
					System.out.println(lista_seguradora.get(i).calcularReceita());
				}
			}
				break;
			case SAIR:
                break;
		}
	}
	
	public static void executarOpcaoSubMenu(SubmenuOpcoes opSubmenu) {
		String nomeSeguradora, telefone, email, endereco, tipoCliente, placa, nomeCliente;
		Seguradora seguradora;
		int opcaoListagem;
		switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
			System.out.println("Digite o nome da seguradora:");
			nomeSeguradora = scanner.nextLine();
			nomeSeguradora = scanner.nextLine();
			seguradora = null;
			for (int i = 0; i < lista_seguradora.size(); i++){
				if (lista_seguradora.get(i).getNome().equals(nomeSeguradora)==true){
					seguradora = lista_seguradora.get(i);
				}
			}
			String educacao, classeEco, genero, cpf, cnpj;
			int anoNascimento, anoLicenca, mesLicenca, mesNascimento, diaLicenta, diaNascimento, qtdFuncionarios, idade;
			ClientePF clientePF_cadastrado;
			//recolhendo as informações necessárias para cadastrar o cliente
			System.out.println("Qual o tipo de cliente: PF ou PJ?");
			tipoCliente = scanner.nextLine();
			if (tipoCliente.equals("PF")){
				System.out.println("Digite o nome:");
				nomeCliente = scanner.nextLine();
				System.out.println("Digite o endereco:");
				endereco = scanner.nextLine();
				System.out.println("Digite o grau de educacao:");
				educacao = scanner.nextLine();
				System.out.println("Digite a classe economica:");
				classeEco = scanner.nextLine();
				System.out.println("Digite o genero:");
				genero = scanner.nextLine();
				System.out.println("Digite o cpf:");
				cpf = scanner.nextLine();
				System.out.println("Digite ano, mes e dia do nascimento, após cada um aperte enter:");
				anoNascimento = scanner.nextInt();
				mesNascimento = scanner.nextInt();
				diaNascimento = scanner.nextInt();
				idade = 2023 - anoNascimento;
				System.out.println("Digite ano, mes e dia da licenca, após cada um aperte enter:");
				anoLicenca = scanner.nextInt();
				mesLicenca = scanner.nextInt();
				diaLicenta = scanner.nextInt();
				//Fazendo a checagem dos dados para aprovar o cadastro
				if(Validacao.validaNome(nomeCliente)==false){
					System.out.println("Opção inválida de nome. Retornando para o menu principal");
				}
				if (Validacao.validarCPF(cpf)==false){
					System.out.println("Cpf invalido. Retornando para o menu principal.");
				}
				//criação da instância de cliente e inserção na seguradora
				if(Validacao.validarCPF(cpf)==true && Validacao.validaNome(nomeCliente)==true){
					clientePF_cadastrado = new ClientePF(nomeCliente, endereco, anoLicenca, mesLicenca, diaLicenta, anoNascimento, mesNascimento, diaNascimento, educacao, genero, classeEco, cpf, idade);
					seguradora.cadastrarCliente(clientePF_cadastrado);
					seguradora.calcularPrecoSeguraCliente(nomeCliente);
				}
			}
			if (tipoCliente.equals("PJ")){
				//coleta de dados necessários para cadastrar o cliente
				System.out.println("Digite o nome:");
				nomeCliente = scanner.nextLine();
				System.out.println("Digite o endereco:");
				endereco = scanner.nextLine();
				System.out.println("Digite o cnpj:");
				cnpj = scanner.nextLine();
				System.out.println("Quantos funcionarios tem a empresa?");
				qtdFuncionarios = scanner.nextInt();
				System.out.println("Digite ano, mes e dia da fundacao, após cada um aperte enter:");
				anoNascimento = scanner.nextInt();
				mesNascimento = scanner.nextInt();
				diaNascimento = scanner.nextInt();
				//validação do cnpj do cliente
				if (Validacao.validarCNPJ(cnpj)==false){
					System.out.println("CNPJ invalido. Voltando para o menu principal");
				}
				//criação da instancia de cliente e inserção na seguradora
				ClientePJ clientePJ_cadastrado = new ClientePJ(nomeCliente, endereco, cnpj, qtdFuncionarios, anoNascimento, mesNascimento, diaNascimento);
				seguradora.cadastrarCliente(clientePJ_cadastrado);
				seguradora.calcularPrecoSeguraCliente(nomeCliente);
        }
			break;
		case CADASTRAR_VEICULO:
			//coletando os dados para a criação do carro
				String marca, modelo;
				int anoFabricacao;
				System.out.println("Digite o nome da seguradora:");
				nomeSeguradora = scanner.nextLine();
				nomeSeguradora = scanner.nextLine();
				seguradora = null;
				for(int i = 0; i < lista_seguradora.size(); i++){
					if (lista_seguradora.get(i).getNome().equals(nomeSeguradora)){
						seguradora = lista_seguradora.get(i);
					} 
				}
				System.out.println("Digite a placa do carro:");
				placa = scanner.nextLine();
				System.out.println("Digite a marca:");
				marca = scanner.nextLine();
				System.out.println("Digite o modelo:");
				modelo = scanner.nextLine();
				System.out.println("Digite o ano de fabricacao:");
				anoFabricacao = scanner.nextInt();
				//criando o carro em sí
				Veiculo carro = new Veiculo(placa, marca, modelo, anoFabricacao);
				//vinculando o veiculo ao cliente pretendido
				System.out.println("Digite o nome do cliente a que esse carro pertence");
				nomeCliente = scanner.nextLine();
				nomeCliente = scanner.nextLine();
				for (int i = 0; i < seguradora.getListaClientes().size(); i++){
					if (seguradora.getListaClientes().get(i).getNome().equals(nomeCliente)==true){
						//adicionando o carro na lista de veiculos do cliente e recalculando o valor do seguro
						seguradora.getListaClientes().get(i).adicionaVeiculo(carro);
						seguradora.calcularPrecoSeguraCliente(nomeCliente);
					}
				}
				break;
		case CADASTRAR_SEGURADORA:
			System.out.println("Digite o nome da seguradora:");
			nomeSeguradora = scanner.nextLine();
			nomeSeguradora = scanner.nextLine();
			System.out.println("Digite o telefone:");
			telefone = scanner.nextLine();
			System.out.println("Digite o email:");
			email = scanner.nextLine();
			System.out.println("Digite o endereco:");
			endereco = scanner.nextLine();
			Seguradora seguradora_nova = new Seguradora(nomeSeguradora, telefone, email, endereco);
			lista_seguradora.add(seguradora_nova);
			System.out.println("Nova seguradora cadastrada: " + seguradora_nova.getNome());
			break;
		case LISTAR_CLIENTES:
			System.out.println("Digite o nome da seguradora:");
			nomeSeguradora = scanner.nextLine();
			nomeSeguradora = scanner.nextLine();
			seguradora = null;
			for(int i = 0; i < lista_seguradora.size(); i++){
				if (lista_seguradora.get(i).getNome().equals(nomeSeguradora)){
					seguradora = lista_seguradora.get(i);
				} 
			}
			System.out.println("Qual o tipo de cliente a ser listado (PF ou PJ):");
            tipoCliente = scanner.nextLine();
            if (seguradora != null){
				seguradora.listarClientes(tipoCliente);
			}
			break;
		case LISTAR_SINISTROS:
			System.out.println("Digite o nome da seguradora:");
			nomeSeguradora = scanner.nextLine();
			nomeSeguradora = scanner.nextLine();
			seguradora = null;
			for(int i = 0; i < lista_seguradora.size(); i++){
				if (lista_seguradora.get(i).getNome().equals(nomeSeguradora)){
					seguradora = lista_seguradora.get(i);
				} 
			}
			if (seguradora != null){
				System.out.println("Listar todos os sinistros da seguradora (Opção: 1) ou os sinistros de um cliente (Opcao: 2)");
				opcaoListagem = scanner.nextInt();
				if (opcaoListagem == 1){
					seguradora.listarSinistrosSeguradora();
				}
				if (opcaoListagem == 2){
					System.out.println("Digite o nome do cliente:");
					nomeCliente = scanner.nextLine();
					nomeCliente = scanner.nextLine();
					System.out.println("Sinistros vinculados ao cliente:");
					seguradora.listarSinistrosCliente(nomeCliente);
				}
			}
			break;
		case LISTAR_VEICULOS:
			System.out.println("Digite o nome da seguradora:");
			nomeSeguradora = scanner.nextLine();
			nomeSeguradora = scanner.nextLine();
			seguradora = null;
			for(int i = 0; i < lista_seguradora.size(); i++){
				if (lista_seguradora.get(i).getNome().equals(nomeSeguradora)){
					seguradora = lista_seguradora.get(i);
				} 
			}
			System.out.println("Listar veiculos cadastrados na seguradora (opcao: 1) ou de um cliente (opcao 2)?");
			opcaoListagem = scanner.nextInt();
			if (opcaoListagem == 1){
				System.out.println("Listando os veiculos por seguradora:");
                seguradora.listarVeiculosPorSeguradora();
			}
			if (opcaoListagem == 2){
				System.out.println("Digite o nome do cliente:");
                nomeCliente = scanner.nextLine();
				nomeCliente = scanner.nextLine();
                System.out.println("Veiculos do cliente:");
                seguradora.listarVeiculoPorCliente(nomeCliente);
			}
			break;
		case EXCLUIR_CLIENTE:
			System.out.println("Digite o nome da seguradora que o cliente esta cadastrado:");
			nomeSeguradora = scanner.nextLine();
			nomeSeguradora = scanner.nextLine();
			seguradora = null;
			for(int i = 0; i < lista_seguradora.size(); i++){
				if (lista_seguradora.get(i).getNome().equals(nomeSeguradora)){
					seguradora = lista_seguradora.get(i);
				} 
			}
			System.out.println("Digite o nome do cliente a ser excluido:");
            nomeCliente = scanner.nextLine();
            seguradora.excluiCliente(nomeCliente);
            System.out.println("Cliente excluido");
			break;
		case EXCLUIR_VEICULO:
			System.out.println("Digite o nome da seguradora que o cliente esta cadastrado:");
			nomeSeguradora = scanner.nextLine();
			nomeSeguradora = scanner.nextLine();
			seguradora = null;
			for(int i = 0; i < lista_seguradora.size(); i++){
				if (lista_seguradora.get(i).getNome().equals(nomeSeguradora)){
					seguradora = lista_seguradora.get(i);
				} 
			}
			System.out.println("Digite o nome do dono do veiculo:");
            nomeCliente = scanner.nextLine();
            System.out.println("Digite a placa do veiculo:");
            placa = scanner.nextLine();
            seguradora.excluiVeiculo(nomeCliente, placa);
        	seguradora.calcularPrecoSeguraCliente(nomeCliente);
            System.out.println("Veiculo excluido.");
			break;
		case EXCLUIR_SINISTRO:
			System.out.println("Digite o nome da seguradora que o cliente esta cadastrado:");
			nomeSeguradora = scanner.nextLine();
			nomeSeguradora = scanner.nextLine();
			seguradora = null;
			for(int i = 0; i < lista_seguradora.size(); i++){
				if (lista_seguradora.get(i).getNome().equals(nomeSeguradora)){
					seguradora = lista_seguradora.get(i);
				} 
			}
			System.out.println("DIgite o nome do cliente que terá os sinistros excluidos:");
			nomeCliente = scanner.nextLine();
			seguradora.excluiSinistro(nomeCliente);
			seguradora.calcularPrecoSeguraCliente(nomeCliente);
            System.out.println("Todos os sinistros do cliente foram removidos com sucesso.");
			break;
		case VOLTAR:
			break;
		}
	}
	
	//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
	private static void executarSubmenu(MenuOpcoes op) {
		SubmenuOpcoes opSubmenu;
		do {
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu);
		}while(opSubmenu != SubmenuOpcoes.VOLTAR);
	}
	
	//executa o menu externo: exibição do menu, leitura da opção e execução da opção
	public static void main(String[] args) {
		MenuOpcoes op;
		//Essa sessão instancia os elementos iniciais/teste
		Seguradora primeira_seguradora = new Seguradora("Porto Seguro", "40028922", "portoseguro@gmail.com", "Rua do Porto");
		lista_seguradora.add(primeira_seguradora);
		ClientePF clientePF = new ClientePF("Erivelton", "Rua acre", 2023, 6, 12, 2002, 3, 30, "Superior Incompleto", "Masculino", "Media", "463.094.788-42", 21);
		primeira_seguradora.cadastrarCliente(clientePF);
		ClientePJ clientePJ = new ClientePJ("Squack", "Avenida MottoMotto", "96.248.077/0001-54", 58, 1984, 7, 28);
		primeira_seguradora.cadastrarCliente(clientePJ);
		Veiculo carroPF = new Veiculo("ABC1234", "Fiat", "UNO", 2022);
		Veiculo carroPJ = new Veiculo("DEF5678", "Fiat", "Combi", 2008);
		clientePF.adicionaVeiculo(carroPF);
		clientePJ.adicionaVeiculo(carroPJ);
		primeira_seguradora.gerarSinistro("Erivelton", "ABC1234", "Av. Paulista", 2023, 9, 4);
		primeira_seguradora.gerarSinistro("Squack", "DEF5678", "Rua Santa Magnolia", 2010, 8, 22);
		//Essa sessão faz as impressões pedidas para teste
		primeira_seguradora.listarClientes("PF");
		primeira_seguradora.listarSinistrosSeguradora();
		primeira_seguradora.visualizarSinistro("Erivelton");
		primeira_seguradora.calcularPrecoSeguraCliente("Erivelton");
		primeira_seguradora.calcularPrecoSeguraCliente("Squack");
		System.out.println(primeira_seguradora.calcularReceita());
		//Inicio do Menu interativo
		do {
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op);
		}while(op != MenuOpcoes.SAIR);
		System.out.println("Saiu do sistema");
	}

}