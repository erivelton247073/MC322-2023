import java.util.Random;

public class Sinistro {
    
    /*Classe: Sinistro
     * Construtor: Sinistro(String data, String endereco)
     * Objetivo: Ativada quando o serviço de seguro é ativado, definindo quando e onde foi ativado, além de dar um id para o caso
     */
    
    private int id;
    private String data;
    private String endereco;

    //Construtor
    public Sinistro(String data, String endereco){
        this.data = data;
        this.endereco = endereco;
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
}