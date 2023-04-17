public class Veiculo {

    /*Classe: Veículo
     * Construtor: Veiculo(String placa, String marca, String modelo)
     * Objetivo: definir as propriedades e métodos da classe Veículo
     */

    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    //Metodo Construtor
    public Veiculo(String placa, String marca, String modelo, int anoFabricacao){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    //Getters e setters
    public int getAnoFabricacao(){
        return anoFabricacao;
    }
    public void setAnoFabricacao(int novoAnoFabricacao){
        this.anoFabricacao = novoAnoFabricacao;
    }

    public String getPlaca(){
        return placa;
    }
    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String toString(){
        return "Marca: "+ marca + "\nModelo: " + modelo + "\nPlaca: "+ placa + "\nAno de fabricacao: " + anoFabricacao;
    }
}