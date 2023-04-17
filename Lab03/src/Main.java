import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Date data = new Date(0);
        String tipoCliente, nome,nome1,nome2,nome_remocao, endereco, ensino, genero, classeEconomica, cpf, cnpj, dia, placa, marca, modelo, telefone, email;
        int anoFabricacao;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Nome da seguradora:\n");
        nome = entrada.nextLine();
        System.out.print("Telefone da seguradora:\n");
        telefone = entrada.nextLine();
        System.out.print("Email da seguradora:\n");
        email = entrada.nextLine();
        System.out.print("Endereco:\n");
        endereco = entrada.nextLine();
        Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);

        System.out.print("Vamos comecar a criar um cliente pessoa fisica.\n");
        System.out.print("Nome do cliente:\n");
        nome = entrada.nextLine();
        System.out.print("Endereco do cliente:\n");
        endereco = entrada.nextLine();
        System.out.print("Qual o nível de instrucao?\n");
        ensino = entrada.nextLine();
        System.out.print("Qual o genero?\n");
        genero = entrada.nextLine();
        System.out.print("Classe economica?\n");
        classeEconomica = entrada.nextLine();
        System.out.print("Qual o CPF?\n");
        cpf = entrada.nextLine();
        ClientePF clientePF1 = new ClientePF(nome, endereco, data, ensino, genero, classeEconomica, cpf, data);

        System.out.print("Vamos criar o carro do cliente\n");
        System.out.print("Placa do carro:\n");
        placa = entrada.nextLine();
        System.out.print("Marca do carro:\n");
        marca = entrada.nextLine();
        System.out.print("MOdelo:\n");
        modelo = entrada.nextLine();
        System.out.print("Ano de fabricacao:\n");
        anoFabricacao = entrada.nextInt();
        Veiculo carro1 = new Veiculo(placa, marca, modelo, anoFabricacao);

        //Adicionando o veiculo no clientePF1 e adicionando o cliente na seguradora
        clientePF1.adicionaVeiculo(carro1);
        seguradora.cadastrarCliente(clientePF1);

        System.out.print("Vamos comecar a criar um cliente pessoa juridica.\n");
        System.out.print("Nome do cliente:\n");
        nome1 = entrada.nextLine();
        nome1 = entrada.nextLine();
        System.out.print("Endereco do cliente:\n");
        endereco = entrada.nextLine();
        System.out.print("CNPJ do cliente:\n");
        cnpj = entrada.nextLine();
        ClientePJ clientePJ1 = new ClientePJ(nome1, endereco, cnpj, data);

        System.out.print("Vamos criar o carro do cliente PJ\n");
        System.out.print("Placa do carro:\n");
        placa = entrada.nextLine();
        System.out.print("Marca do carro:\n");
        marca = entrada.nextLine();
        System.out.print("Modelo:\n");
        modelo = entrada.nextLine();
        System.out.print("Ano de fabricacao:\n");
        anoFabricacao = entrada.nextInt();
        Veiculo carro2 = new Veiculo(placa, marca, modelo, anoFabricacao);

        //adicionando o carro 2 ao cliente PJ1 e colocando-o dentro da seguradora
        clientePJ1.adicionaVeiculo(carro2);
        seguradora.cadastrarCliente(clientePJ1);
        
        System.out.print("Vamos comecar a criar mais um cliente pessoa fisica diferente do primeiro.\n");
        System.out.print("Nome do cliente:\n");
        nome2 = entrada.nextLine();
        nome2 = entrada.nextLine();
        System.out.print("Endereco do cliente:\n");
        endereco = entrada.nextLine();
        System.out.print("Qual o nível de instrucao?\n");
        ensino = entrada.nextLine();
        System.out.print("Qual o genero?\n");
        genero = entrada.nextLine();
        System.out.print("Classe economica?\n");
        classeEconomica = entrada.nextLine();
        System.out.print("Qual o CPF?\n");
        cpf = entrada.nextLine();
        ClientePF clientePF2 = new ClientePF(nome2, endereco, data, ensino, genero, classeEconomica, cpf, data);

        System.out.print("Vamos criar o carro do cliente PF2\n");
        System.out.print("Placa do carro:\n");
        placa = entrada.nextLine();
        System.out.print("Marca do carro:\n");
        marca = entrada.nextLine();
        System.out.print("Modelo:\n");
        modelo = entrada.nextLine();
        System.out.print("Ano de fabricacao:\n");
        anoFabricacao = entrada.nextInt();
        Veiculo carro3 = new Veiculo(placa, marca, modelo, anoFabricacao);

        //adicionando o carro 3 ao cliente PF2 e colocando-o dentro da seguradora
        clientePF2.adicionaVeiculo(carro3);
        seguradora.cadastrarCliente(clientePF2);

        System.out.print("Qual tipo de cliente cadastrado na seguradora gostaria de ver? Digite PF ou PJ\n");
        tipoCliente = entrada.nextLine();
        tipoCliente = entrada.nextLine();
        seguradora.listarClientes(tipoCliente);

        System.out.print("Escreva o nome do cliente que deseja remover (com a mesma grafia, incluindo caracteres maiusculos):\n");
        nome_remocao = entrada.nextLine();
        seguradora.removerCliente(nome_remocao);
        System.out.print("Monstrando a lista de clientes apos a remocao:\n");
        seguradora.listarClientes("PF");
        seguradora.listarClientes("PJ");


        System.out.print("Fazendo um sinistro para o clientePF1:\n");
        System.out.print("Digite Quando aconteceu:\n");
        dia = entrada.nextLine();
        System.out.print("Onde aconteceu:\n");
        endereco = entrada.nextLine();
        seguradora.gerarSinistro(endereco, dia, carro1, clientePF1);
        System.out.print("Vamos ver se o sinistro foi adicionado\nDigite o nome do clientePF1:\n");
        nome = entrada.nextLine();
        System.out.println(seguradora.visualizarSinistro(nome));

        System.out.print("Vamos listar os sinistros agora:\n");
        seguradora.listarSinistros();
        entrada.close();
    }
}
