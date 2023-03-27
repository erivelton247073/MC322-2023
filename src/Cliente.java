public class Cliente{

    /*Classe: Cliente
     * Construtor: Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco)
     * Objetivo: definir propriedades e métodos da classe Cliente
     */

    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    //Contrutor
    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    //Getters e Setters
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    //Metodo para validar o CPF do cliente
    public boolean validarCPF(){
        String cpfValidacao = this.cpf;
        //Primeiro vamos formatar o cpf
        cpfValidacao = cpfValidacao.replaceAll("\\D","");
        //conferindo se cpf possui 11 dígitos
        if (cpfValidacao.length() != 11){
            System.out.println("CPF invalido");
            return false;
        }
        //conferindo se todos os dígitos são iguais
        Boolean todos_digitos_iguais = true;
        for (int i=1; i < cpfValidacao.length(); i++){
            if (cpfValidacao.charAt(0) != cpfValidacao.charAt(i)){
                todos_digitos_iguais = false;
            }     
        }
        if (todos_digitos_iguais == true){
            System.out.println("CPF invalido");
            return false;
        }
        //separando os dígitos verificadores para teste
        String ultimosDigitos = cpfValidacao.substring(cpfValidacao.length() - 2);
        int digitos_verificadores = Integer.parseInt(ultimosDigitos);
        int digito_v1 = digitos_verificadores/10;
        int digito_v2 = digitos_verificadores%10;
        int soma1 = 0;
        int soma2 = 0;
        //realizando as operações necessárias para calcular os dígitos verificadores
        for (int i = 0, multiplicador = 10; i < 9; i++, multiplicador--){
            //Diminuindo 48 por causa da tabela ASCII
            int algarismo = cpfValidacao.charAt(i) - 48;
            soma1 += (algarismo*multiplicador);
        }
        int digito_v1_encontrado;
        if(soma1%11 != 0 && soma1%11 != 1){
            digito_v1_encontrado = 11 - (soma1%11);
        } else {
            digito_v1_encontrado = 0;
        }
        for (int i = 1, multiplicador = 10; i < 10; i++, multiplicador--){
            //Diminuindo 48 por causa da tabela ASCII
            int algarismo = cpfValidacao.charAt(i) - 48;
            soma2 += (algarismo*multiplicador);
        }
        int digito_v2_encontrado;
        if(soma2%11 != 0 && soma2%11 != 1){
            digito_v2_encontrado = 11 - (soma2%11);
        } else {
            digito_v2_encontrado = 0;
        }
        if (digito_v1 == digito_v1_encontrado && digito_v2 == digito_v2_encontrado){
            System.out.println("CPF valido");
            return true;
        } else {
            System.out.println("CPF invalido");
            return false;
        }
    }
}