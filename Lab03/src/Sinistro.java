import java.util.Random;

public class Sinistro {
    
    /*Classe: Sinistro
     * Construtor: Sinistro(String data, String endereco)
     * Objetivo: Ativada quando o serviço de seguro é ativado, definindo quando e onde foi ativado, além de dar um id para o caso
     */
    
    private final int id;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    //Construtor
    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        //Como o id será um número aleatório, ele não aceita entrada, sendo definido puramente pela sessão abaixo
        this.id  = randomico();
    }

    public int randomico(){
        //Cria o objeto random
        Random gerador = new Random();
        //Gera um id aleatório entre 0 e 999999999
        int id = gerador.nextInt(1000000000);
        return id;
    }

    //Getters e setters
    public int getId(){
        return id;
    }

    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public Seguradora getSeguradora(){
        return seguradora;
    }
    public void setSeguradora(Seguradora seguradora){
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo(){
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public String toString(){
        return "ID: " + id + "\nData: " + data + "\nEndereco: " + endereco + "\nSeguradora: " + seguradora.getNome() + "\nVeiculo: " + veiculo.getPlaca() + "\nCliente: " + cliente.getNome();
    }
}