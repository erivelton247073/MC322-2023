import java.util.Date;

public class ClientePJ extends Cliente {

    /*Classe: ClinetePJ
     * Classe filha de: Cliente
     * Construtor: ClientePJ(String nome, String endereco, String cnpj, Date dataFundacao)
     * Objetivo: Definir propriedades e métodos da classe ClientePJ
     */    

    private final String cnpj;
    private Date dataFundacao;
    
    public ClientePJ(String nome, String endereco, String cnpj, Date dataFundacao){
        super( nome, endereco);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }

    public String getCNPJ() {
        return cnpj;
    }
    public Date getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public boolean validarCNPJ(String cnpj){

        //Método responsável por validar o cnpj

        String cnpjValidacao = this.cnpj;
        //Primeiro vamos formatar o cnpj deixando apenas os valores numéricos
        cnpjValidacao = cnpjValidacao.replaceAll("\\D","");
        String digitos_verificadores_string = cnpjValidacao.substring(cnpjValidacao.length() - 2);
        int digitos_verificadores = Integer.parseInt(digitos_verificadores_string);
        int digito_v1 = digitos_verificadores/10;
        int digito_v2 = digitos_verificadores%10;
        //esse String é arbritária pra validação do cnpj
        String lista_numeros_verificadores = ("543298765432");
        int soma = 0;
        for (int i = 0; i < 12; i++){
            //Diminuindo 48 por causa da tabela ASCII
            int algarismo = cnpjValidacao.charAt(i) - 48;
            int multiplicador = lista_numeros_verificadores.charAt(i) - 48;
            soma += (algarismo*multiplicador);
        }
        int primeiro_dig_verificador;
        if(soma%11 != 0 && soma%11 != 1){
            primeiro_dig_verificador = 11 - (soma%11);
        } else {
            primeiro_dig_verificador = 0;
        }
        lista_numeros_verificadores = ("6543298765432");
        soma = 0;
        for (int i = 0; i < 13; i++){
            //Diminuindo 48 por causa da tabela ASCII
            int algarismo = cnpjValidacao.charAt(i) - 48;
            int multiplicador = lista_numeros_verificadores.charAt(i) - 48;
            soma += (algarismo*multiplicador);
        }
        int segundo_dig_verificador;
        if(soma%11 != 0 && soma%11 != 1){
            segundo_dig_verificador = 11 - (soma%11);
        } else {
            segundo_dig_verificador = 0;
        }
        if (digito_v1 == primeiro_dig_verificador && digito_v2 == segundo_dig_verificador){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return super.toString() + "\nData de Fundacao: " + dataFundacao + "\nCNPJ: " + cnpj + "; CNPJ valido: " + this.validarCNPJ(cnpj) + "\n";
    }
}