import java.util.ArrayList;

public class Cliente{

    /*Classe: Cliente
     * Construtor: Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco)
     * Objetivo: definir propriedades e métodos da classe Cliente
     */

    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;

    //Contrutor
    public Cliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
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

    public void adicionaVeiculo(Veiculo carro){
        this.listaVeiculos.add(carro);
    }

    public String toString(){
        String texto = "";
        for (Veiculo veiculo: listaVeiculos){
            texto += veiculo.toString();
        }
        return "Nome: " + nome + "\nEndereço: " + endereco +  "\nVeículos:\n" + texto; 
    }
}