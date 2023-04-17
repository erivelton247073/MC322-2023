import java.util.ArrayList;

public class Seguradora {

    /*Classe: Seguradora
     * Construtor:Seguradora(String nome, String telefone, String email, String endereco)
     * Objetivo: Definir propriedades e métodos da classe Seguradora
     */

    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistro;
    private ArrayList<Cliente> listaClientes;

    //Construtor
    public Seguradora(String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistro = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
    }

    //Getters e Setters
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void cadastrarCliente(Cliente cliente){
        
        //Método para cadastrar cliente na seguradora
        
        listaClientes.add(cliente);
    }

    public boolean removerCliente(String nomeCliente){
        
        //Método que remove clientes da seguradora

        for (int i = 0; i < listaClientes.size(); i++){
            if (listaClientes.get(i).getNome().equals(nomeCliente)){
                listaClientes.remove(i);
                return true; //a remoção foi concluída
            }
        }
        return false;
    }

    public ArrayList<Cliente> listarClientes(String tipoCliente){
        
        //Método responsável por listar os clientes de uma determinada categoria

        ArrayList<Cliente> lista_retornada = new ArrayList<>();
        if (tipoCliente.equals("PF")){
            for (int i = 0; i < listaClientes.size(); i++){
                if(listaClientes.get(i) instanceof ClientePF){
                    lista_retornada.add(listaClientes.get(i));
                }
            }
        }
        if (tipoCliente.equals("PJ")){
            for (int i = 0; i < listaClientes.size(); i++){
                if(listaClientes.get(i) instanceof ClientePJ){
                    lista_retornada.add(listaClientes.get(i));
                }
            }
        }
        for (int i = 0; i < lista_retornada.size(); i++){
            System.out.println(lista_retornada.get(i).toString());
        }
        return lista_retornada;
    }
    
    public boolean gerarSinistro(String endereco, String data, Veiculo veiculo, Cliente cliente){

        //Método que cria um Sinistro e o veicula a um cliente

        Sinistro sinistro = new Sinistro(data, endereco, this, veiculo, cliente);
        listaSinistro.add(sinistro);
        return true;
    }

    public boolean visualizarSinistro(String cliente){

        //Método que permite visualizar se um cliente possui um sinistro em seu nome

        for (int i = 0; i < listaSinistro.size(); i++){
            if (listaSinistro.get(i).getCliente().getNome().equals(cliente)){
                System.out.println(listaSinistro.get(i).toString());
                return true;
            }
        }
        return false;
    }

    public boolean listarSinistros(){

        //Método que lista todos os sinistros registrados

        for (int i = 0; i < listaSinistro.size(); i++){
            System.out.println(listaSinistro.get(i).toString());
        }
        return true;
    }
    
}