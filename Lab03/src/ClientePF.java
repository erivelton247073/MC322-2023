import java.util.Date;

public class ClientePF extends Cliente{

    /*Classe: ClinetePF
     * Classe filha de: Cliente
     * Construtor: ClientePF(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, String cpf, Date dataNascimento)
     * Objetivo: Definir propriedades e métodos da classe ClientePF
     */ 

    private final String cpf;
    private Date dataNascimento;
    private Date dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, String cpf, Date dataNascimento){
        //chama o construtor da superclasse
        super( nome, endereco);
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        
    }
    public Date getDataLicenca(){
        return dataLicenca;
    }
    public void setDataLicenca(Date dataLicenca){
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao(){
        return educacao;
    }
    public void setEducacao(String educacao){
        this.educacao = educacao;
    }

    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getClasseEconomica(){
        return classeEconomica;
    }
    public void setClasseEconomica(String classeEconomica){
        this.classeEconomica = classeEconomica;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    public boolean validarCPF(){
        
        //Metodo para validar o CPF do cliente
        
        String cpfValidacao = this.cpf;
        //Primeiro vamos formatar o cpf
        cpfValidacao = cpfValidacao.replaceAll("\\D","");
        //conferindo se cpf possui 11 dígitos
        if (cpfValidacao.length() != 11){
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
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return super.toString() +"\nData de Licença: " + dataLicenca + "\nEducação: " + educacao + "\nGênero: " + genero + "\nClasse Econômica: " + classeEconomica + "\nData de Nascimento: " + dataNascimento + "\nCPF: " + cpf + ", CPF válido: " + this.validarCPF() + "\n";
    }

}