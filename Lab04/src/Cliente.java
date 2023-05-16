import java.util.ArrayList;

public class Cliente{

    /*Classe: Cliente
     * Construtor: Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco)
     * Objetivo: definir propriedades e métodos da classe Cliente
     */

    private String nome;
    private String endereco;
    private double valorSeguro;
    protected ArrayList<Veiculo> listaVeiculos;

    //Contrutor
    public Cliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
        this.valorSeguro = 0;
        this.listaVeiculos = new ArrayList<>();
    }

    //getter e setter
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public double getValorSeguro(){
        return valorSeguro;
    }
    public void setValorSeguro(double valor){
        this.valorSeguro = valor;
    }

    public void adicionaVeiculo(Veiculo carro){
        this.listaVeiculos.add(carro);
    }

    public ArrayList<Veiculo> getListaVeiculos(){
        return listaVeiculos;
    }

    public double calculaScore(){
        return CalcSegura.VALOR_BASE.fatoresOperacionais;
    }    

    public String toString(){
        String texto = "";
        for (Veiculo veiculo: listaVeiculos){
            texto += veiculo.toString();
        }
        return "Nome: " + nome + "\nEndereço: " + endereco +  "\nVeículos:\n" + texto; 
    }
}