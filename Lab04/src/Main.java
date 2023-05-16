import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        ArrayList<Cliente> lista_todos_clientes = new ArrayList<>();//será usada para a passagem de parâmetros para a geração de sinistros
        //instanciando uma seguradora
        Seguradora seguradora = new Seguradora("Porto Seguro", "4002-8922", "porto.seguro@gmail.com.br", "Av. Paulista");

        //instanciando veículos
        Veiculo carro_1 = new Veiculo("ABC1D23", "Fiat", "Uno", 2020);
        Veiculo carro_2 = new Veiculo("EFJ4K56", "Wolksvagen", "Taus", 2022);

        //Instanciando um cliente PF
        ClientePF clientePF = new ClientePF("Isabelle", "Rua Chile", 1998, 6, 14, 1980, 3, 27, "Ensino Superior completo", "Feminino", "Classe B+", "392-482-518.11");

        //Instanciando um cliente PJ
        ClientePJ clientePJ = new ClientePJ("Corujeira LTDA", "Rua Dr. Carlos Francisco de Paula - ES", "57.864.928/0001-31", 12, 2007, 11, 30);

        //Adicionando os veículos, uma para cada cliente
        clientePF.adicionaVeiculo(carro_2);
        clientePJ.adicionaVeiculo(carro_1);

        //Cadastrando os clientes na seguradora e calculando os valores de seguro
        seguradora.cadastrarCliente(clientePJ);
        lista_todos_clientes.add(clientePJ);
        seguradora.calcularPrecoSeguraCliente("Corujeira LTDA");
        seguradora.cadastrarCliente(clientePF);
        lista_todos_clientes.add(clientePF);
        seguradora.calcularPrecoSeguraCliente("Isabelle");

        System.out.println(seguradora.calcularReceita());//Receita antes da atulaização
        System.out.println("\n");
    
        //Criando instâncias de Sinistro e atualizando o valor dos seguros
        seguradora.gerarSinistro("Av. Brasil", seguradora, carro_2, clientePF, 12, 3, 2023);
        seguradora.gerarSinistro("Av. Uruguai", seguradora, carro_1, clientePJ, 13, 4, 2022);
        seguradora.calcularPrecoSeguraCliente("Corujeira LTDA");
        seguradora.calcularPrecoSeguraCliente("Isabelle");

        //Chamando os métodos listarClientes(), vizualizarSinistro() e calcularReceita()
        seguradora.listarClientes("PJ");//primeiro para clientes PJ
        System.out.println("\n");
        seguradora.listarClientes("PF");//agora para clientes PF

        System.out.println("\n");
        seguradora.visualizarSinistro("Isabelle");//Vizualizando o sinistro pertencente a isabelle

        System.out.println("\n");
        seguradora.listarSinistrosSeguradora();//Listando todos os sinistros pertencentes a uma seguradora

        System.out.println("\n");
        System.out.println(seguradora.calcularReceita() + "\n");//Receita após a atualização

        //criando as variáveis para usar no menu interativo
        Scanner entrada = new Scanner(System.in);
        //criação das variaveis que serão passadas como parametros
        int operacao_menu = 10;//meramente garantindo que seja diferente de 0
        int sub_operacao = 100;
        String tipoCliente, nome, nome2, telefone, email, endereco, placa, marca, modelo, cpf, cnpj, educacao, genero, classeEco;
        int anoLicenca, mesLicenca, diaLicenta, anoNascimento, mesNascimento, diaNascimento, qtdFuncionarios; 
        //loop while que representa o menu interativo
        while (operacao_menu != 0){
            System.out.println("***Menu Principal***\n1-Cadastros\n2-Listar\n3-Excluir\n4-Gerar Sinistro\n5-Transferir Seguro\n6-Calcular Receita Seguradora\n0-Sair");
            System.out.println("Por favor, digite o indice da opcao desejada juntando o número antes e depois do ponro como se fosse escrever um numero inteiro");
            operacao_menu = entrada.nextInt();
            //esse primeiro seitch é para o menu principal
            switch(operacao_menu){
                case 1:
                    System.out.println("***Menu Cadastrar***\n1.1-Cadastrar Cliente PF/PJ\n1.2-Cadastrar Veiculo\n1.3-Cadastrar Seguradora\n1.4-Voltar");
                    System.out.println("Por favor, digite o indice da opcao desejada juntando o número antes e depois do ponto como se fosse escrever um numero inteiro");
                    sub_operacao = entrada.nextInt();
                    //switch usado para navegar pelo menu de cadastros
                    //todos os continues vão finalizar a volta atual e passar para a próxima volta do while
                    switch(sub_operacao){
                        case 11:{
                            //recolhendo as informações necessárias para cadastrar o cliente
                            System.out.println("Qual o tipo de cliente: PF ou PJ?");
                            tipoCliente = entrada.nextLine();
                            tipoCliente = entrada.nextLine();
                            if (tipoCliente.equals("PF")){
                                System.out.println("Digite o nome:");
                                nome = entrada.nextLine();
                                System.out.println("Digite o endereco:");
                                endereco = entrada.nextLine();
                                System.out.println("Digite o grau de educacao:");
                                educacao = entrada.nextLine();
                                System.out.println("Digite a classe economica:");
                                classeEco = entrada.nextLine();
                                System.out.println("Digite o genero:");
                                genero = entrada.nextLine();
                                System.out.println("Digite o cpf:");
                                cpf = entrada.nextLine();
                                System.out.println("Digite ano, mes e dia do nascimento, após cada um aperte enter:");
                                anoNascimento = entrada.nextInt();
                                mesNascimento = entrada.nextInt();
                                diaNascimento = entrada.nextInt();
                                System.out.println("Digite ano, mes e dia da licenca, após cada um aperte enter:");
                                anoLicenca = entrada.nextInt();
                                mesLicenca = entrada.nextInt();
                                diaLicenta = entrada.nextInt();
                                //Fazendo a checagem dos dados para aprovar o cadastro
                                if(Validacao.validaNome(nome)==false){
                                    System.out.println("Opção inválida de nome. Retornando para o menu principal");
                                    continue;
                                }
                                if (Validacao.validarCPF(cpf)==false){
                                    System.out.println("Cpf invalido. Retornando para o menu principal.");
                                    continue;
                                }
                                //criação da instância de cliente e inserção na seguradora
                                ClientePF clientePF_cadastrado = new ClientePF(nome, endereco, anoLicenca, mesLicenca, diaLicenta, anoNascimento, mesNascimento, diaNascimento, educacao, genero, classeEco, cpf);
                                lista_todos_clientes.add(clientePF_cadastrado);//adicionando na lista geral para depois trabalhar com a geração de sinistros
                                seguradora.cadastrarCliente(clientePF_cadastrado);
                            }
                            if (tipoCliente.equals("PJ")){
                                //coleta de dados necessários para cadastrar o cliente
                                System.out.println("Digite o nome:");
                                nome = entrada.nextLine();
                                System.out.println("Digite o endereco:");
                                endereco = entrada.nextLine();
                                System.out.println("Digite o cnpj:");
                                cnpj = entrada.nextLine();
                                System.out.println("Quantos funcionarios tem a empresa?");
                                qtdFuncionarios = entrada.nextInt();
                                System.out.println("Digite ano, mes e dia da fundacao, após cada um aperte enter:");
                                anoNascimento = entrada.nextInt();
                                mesNascimento = entrada.nextInt();
                                diaNascimento = entrada.nextInt();
                                //validação do cnpj do cliente
                                if (Validacao.validarCNPJ(cnpj)==false){
                                    System.out.println("CNPJ inalido. Voltando para o menu principal");
                                    continue;
                                }
                                //criação da instancia de cliente e inserção na seguradora
                                ClientePJ clientePJ_cadastrado = new ClientePJ(nome, endereco, cnpj, qtdFuncionarios, anoNascimento, mesNascimento, diaNascimento);
                                lista_todos_clientes.add(clientePJ_cadastrado);//Adicionando na lista geral para depois trabalhar com a geração de sinistros
                                seguradora.cadastrarCliente(clientePJ_cadastrado);
                            }
                            continue;
                        }
                        case 12:{
                            //coletando os dados para a criação do carro
                            System.out.println("Digite a placa do carro:");
                            placa = entrada.nextLine();
                            placa = entrada.nextLine();
                            System.out.println("Digite a marca:");
                            marca = entrada.nextLine();
                            System.out.println("Digite o modelo:");
                            modelo = entrada.nextLine();
                            System.out.println("Digite o ano de fabricacao:");
                            anoNascimento = entrada.nextInt();
                            //criando o carro em sí
                            Veiculo carro = new Veiculo(placa, marca, modelo, anoNascimento);
                            //vinculando o veiculo ao cliente pretendido
                            System.out.println("Digite o nome do cliente a que esse carro pertence");
                            nome = entrada.nextLine();
                            nome = entrada.nextLine();
                            for (int i = 0; i < lista_todos_clientes.size(); i++){
                                if (lista_todos_clientes.get(i).getNome().equals(nome)==true){
                                    //adicionando o carro na lista de veiculos do cliente e recalculando o valor do seguro
                                    lista_todos_clientes.get(i).adicionaVeiculo(carro);
                                    seguradora.calcularPrecoSeguraCliente(nome);
                                }
                            }
                            continue;
                        }
                        case 13:{
                            //coletando os dados necessários para a criação de uma nova seguradora
                            System.out.println("Digite o nome da seguradora:");
                            nome = entrada.nextLine();
                            nome = entrada.nextLine();
                            System.out.println("Digite o telefone:");
                            telefone = entrada.nextLine();
                            System.out.println("Digite o email:");
                            email = entrada.nextLine();
                            System.out.println("Digite o endereco:");
                            endereco = entrada.nextLine();
                            Seguradora seguradora_nova = new Seguradora(nome, telefone, email, endereco);
                            System.out.println("Nova seguradora cadastrada: " + seguradora_nova.getNome());
                            continue;
                        }
                        case 14:{
                            continue;
                        }
                    }
                case 2:{
                    System.out.println("***Menu Listar***\n2.1-Listar Clientes (PF/PJ)\n2.2-Listar Sinistros por Seguradora\n2.3-Listar Sinistro por Cliente\n2.4-Listar Veiculo por cliente\n2.5-Listar Veiculo por Seguradora\n2.6-Voltar");
                    System.out.println("Por favor, digite o indice da opcao desejada juntando o número antes e depois do ponto como se fosse escrever um numero inteiro");
                    sub_operacao = entrada.nextInt();
                    //switch que trabalha com o menu listar
                    switch (sub_operacao){
                        case 21:{
                            System.out.println("Qual o tipo de cliente a ser listado (PF ou PJ):");
                            tipoCliente = entrada.nextLine();
                            tipoCliente = entrada.nextLine();
                            seguradora.listarClientes(tipoCliente);
                            continue;
                        }
                        case 22:{
                            System.out.println("Listando os sinistros relacionados a seguradora:");
                            seguradora.listarSinistrosSeguradora();
                            continue;
                        }
                        case 23:{
                            System.out.println("Digite o nome do cliente:");
                            nome = entrada.nextLine();
                            nome = entrada.nextLine();
                            System.out.println("Sinistros vinculados ao cliente:");
                            seguradora.listarSinistrosCliente(nome);
                            continue;
                        }
                        case 24:{
                            System.out.println("Digite o nome do cliente:");
                            nome = entrada.nextLine();
                            nome = entrada.nextLine();
                            System.out.println("Veiculos do cliente:");
                            seguradora.listarVeiculoPorCliente(nome);
                            continue;
                        }
                        case 25:{
                            System.out.println("Listando os veiculos por seguradora:");
                            seguradora.listarVeiculosPorSeguradora();
                            continue;
                        }
                        case 26:{
                            continue;
                        }
                    }continue;
                }
                case 3:{
                    System.out.println("***Menu Excluir***\n3.1-Excluir Cliente\n3.2-Excluir Veiculo\n3.3-Excluir Sinistro\n3.4-Voltar");
                    System.out.println("Por favor, digite o indice da opcao desejada juntando o número antes e depois do ponto como se fosse escrever um numero inteiro");
                    sub_operacao = entrada.nextInt();
                    //switch usado para navegar pelo menu excluir
                    switch (sub_operacao){
                        case 31:{
                            System.out.println("Digite o nome do cliente a ser excluido:");
                            nome = entrada.nextLine();
                            nome = entrada.nextLine();
                            seguradora.excluiCliente(nome);
                            System.out.println("Cliente excluido");
                            continue;
                        }
                        case 32:{
                            System.out.println("Digite o nome do dono do veiculo:");
                            nome = entrada.nextLine();
                            nome = entrada.nextLine();
                            System.out.println("Digite a placa do veiculo:");
                            placa = entrada.nextLine();
                            seguradora.excluiVeiculo(nome, placa);
                            seguradora.calcularPrecoSeguraCliente(nome);
                            System.out.println("Veiculo excluido.");
                            continue;
                        }
                        case 33:{
                            System.out.println("Digite o nome do cliente que possui o sinistro:");
                            nome = entrada.nextLine();
                            nome = entrada.nextLine();
                            seguradora.excluiSinistro(nome);
                            System.out.println("Todos os sinistros do cliente foram removidos com sucesso.");
                            continue;
                        }
                        case 34:{
                            continue;
                        }
                    }
                }
                case 4:{
                    System.out.println("Digite o nome do cliente responsavel pelo sinistro:");
                    nome = entrada.nextLine();
                    nome = entrada.nextLine();
                    System.out.println("Digite a placa do carro:");
                    placa = entrada.nextLine();
                    System.out.println("Digite o endereco do sinistro:");
                    endereco = entrada.nextLine();
                    System.out.println("Digite o ano, o mes e o dia, respectivamente, sempre dando enter após cada um:");
                    anoNascimento = entrada.nextInt();
                    mesNascimento = entrada.nextInt();
                    diaNascimento = entrada.nextInt();
                    for (int i = 0; i < lista_todos_clientes.size(); i++){
                        if (lista_todos_clientes.get(i).getNome().equals(nome) == true){
                            for (int j = 0; j < lista_todos_clientes.get(i).getListaVeiculos().size(); j++){
                                if (lista_todos_clientes.get(i).getListaVeiculos().get(j).getPlaca().equals(placa)==true){
                                    seguradora.gerarSinistro(endereco, seguradora, lista_todos_clientes.get(i).getListaVeiculos().get(j) , lista_todos_clientes.get(i) , diaNascimento, mesNascimento, anoNascimento);
                                }
                            }
                        }
                    }
                    continue;
                }
                case 5:{
                    System.out.println("Digite o nome do cliente que ira dar os carros:");
                    nome = entrada.nextLine();
                    nome = entrada.nextLine();
                    System.out.println("Digite o nome do cliente que vai receber:");
                    nome2 = entrada.nextLine();
                    seguradora.transfereSeguro(nome, nome2);
                    continue;
                }
                case 6:{
                    System.out.println("Receita total da seguradora:");
                    System.out.println(seguradora.calcularReceita());
                    continue;
                }
            }
        }
        entrada.close();
    }
    
}