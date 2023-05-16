import java.util.Calendar;

public class ClientePJ extends Cliente {

    /*Classe: ClinetePJ
     * Classe filha de: Cliente
     * Construtor: ClientePJ(String nome, String endereco, String cnpj, Date dataFundacao)
     * Objetivo: Definir propriedades e métodos da classe ClientePJ
     */    

    private final String cnpj;
    private Calendar dataFundacao;
    private double qtdeFuncionarios;
    
    public ClientePJ(String nome, String endereco, String cnpj, int qtdeFuncionarios, int ano, int mes, int dia){
        super( nome, endereco);
        this.cnpj = cnpj;
        this.qtdeFuncionarios = qtdeFuncionarios;
        //Definindo data de Fundação
        this.dataFundacao = Calendar.getInstance();
        dataFundacao.set(Calendar.YEAR, ano);
        dataFundacao.set(Calendar.MONTH, mes);
        dataFundacao.set(Calendar.DAY_OF_MONTH, dia);
    }

    public String getCNPJ() {
        return cnpj;
    }
    public Calendar getDataFundacao() {
        return dataFundacao;
    }

    @Override
    public double calculaScore(){
        return CalcSegura.VALOR_BASE.fatoresOperacionais * (1 + (qtdeFuncionarios)/100) * this.listaVeiculos.size();
    }

    public String toString(){
        return super.toString() + "\nData de Fundacao: " + dataFundacao.get(Calendar.DAY_OF_MONTH) +"/" + dataFundacao.get(Calendar.MONTH) + "/" + dataFundacao.get(Calendar.YEAR) + "\nCNPJ: " + cnpj;
    }
}
