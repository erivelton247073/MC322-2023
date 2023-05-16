import java.util.Calendar;

public class ClientePF extends Cliente{

    /*Classe: ClinetePF
     * Classe filha de: Cliente
     * Construtor: ClientePF(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, String cpf, Date dataNascimento)
     * Objetivo: Definir propriedades e métodos da classe ClientePF
     */ 

    private final String cpf;
    private Calendar dataNascimento;
    private Calendar dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, int anoLicenca, int mesLicenca, int diaLicenca, int anoNascimento, int mesNascimento, int diaNascimento, String educacao, String genero, String classeEconomica, String cpf){
        //chama o construtor da superclasse
        super( nome, endereco);
        this.dataLicenca = Calendar.getInstance();
        this.dataNascimento = Calendar.getInstance();
        //Definindo data de licença
        dataLicenca.set(Calendar.YEAR, anoLicenca);
        dataLicenca.set(Calendar.MONTH, mesLicenca);
        dataLicenca.set(Calendar.DAY_OF_MONTH, diaLicenca);
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.cpf = cpf;
        //Definindo data de nascimento
        dataNascimento.set(Calendar.YEAR, anoNascimento);
        dataNascimento.set(Calendar.MONTH, mesNascimento);
        dataNascimento.set(Calendar.DAY_OF_MONTH, diaNascimento);
        
    }
    public Calendar getDataLicenca(){
        return dataLicenca;
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

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public double calculaScore(){
        int quantidadeCarros = this.listaVeiculos.size();
        //Criando uma instÂncia relativa ao dia de hj
        Calendar hoje = Calendar.getInstance();
        //Calculando a diferença
        long diferença = hoje.getTimeInMillis()-dataLicenca.getTimeInMillis();
        //Transformando os milisegundos em anos
        int idade = (int) (diferença/1000/60/60/24/365);
        if (idade>=18 && idade<30){
            return CalcSegura.VALOR_BASE.fatoresOperacionais * CalcSegura.FATOR_18_30.fatoresOperacionais * quantidadeCarros; 
        } else if (idade>=30 && idade<60){
            return CalcSegura.VALOR_BASE.fatoresOperacionais * CalcSegura.FATOR_30_60.fatoresOperacionais * quantidadeCarros; 
        } else if (idade>=60 && idade<90){
            return CalcSegura.VALOR_BASE.fatoresOperacionais * CalcSegura.FATOR_60_90.fatoresOperacionais * quantidadeCarros; 
        }
        return 0;
    }

    public String toString(){
        return super.toString() +"\nData de Licença: " + dataLicenca.get(Calendar.DAY_OF_MONTH) + "/" + dataLicenca.get(Calendar.MONTH) + "/" + dataLicenca.get(Calendar.YEAR) + "\nEducação: " + educacao + "\nGênero: " + genero + "\nClasse Econômica: " + classeEconomica + "\nData de Nascimento: " + dataNascimento.get(Calendar.DAY_OF_MONTH) +"/"+ dataNascimento.get(Calendar.MONTH) + "/" + dataNascimento.get(Calendar.YEAR) +"\nCPF: " + cpf + ", Validade: " + Validacao.validarCPF(cpf);
    }

}
