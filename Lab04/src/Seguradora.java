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

    public ArrayList<Cliente> getListaClientes(){
        return listaClientes;
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
            //Lista todos os clientes do tipo PF
            for (int i = 0; i < listaClientes.size(); i++){
                if(listaClientes.get(i) instanceof ClientePF){
                    lista_retornada.add(listaClientes.get(i));
                }
            }
        }
        if (tipoCliente.equals("PJ")){
            //Lista todods os clientes do tipo PJ
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
    
    public boolean gerarSinistro(String nomeCliente, String placa, String endereco, int ano, int mes, int dia){

        //Método que cria um Sinistro e o veicula a um cliente
        for (int i = 0; i < listaClientes.size(); i++){
            if (listaClientes.get(i).getNome().equals(nomeCliente)==true){
                for (int j = 0; j < listaClientes.get(i).getListaVeiculos().size(); j++){
                    Sinistro sinistro = new Sinistro(endereco, this, listaClientes.get(i).getListaVeiculos().get(j), listaClientes.get(i), dia, mes, ano);
                    listaSinistro.add(sinistro);
                }
            }
        }
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

    public boolean listarSinistrosSeguradora(){

        //Método que lista todos os sinistros registrados na seguradora

        for (int i = 0; i < listaSinistro.size(); i++){
            System.out.println(listaSinistro.get(i).toString());
        }
        return true;
    }

    public void listarSinistrosCliente(String cliente){

        //Método que lista todos os sinistros no nome de um cliente

        boolean cliente_na_lista = false;
        for (int i = 0; i < listaSinistro.size(); i++){
            if (listaSinistro.get(i).getCliente().getNome().equals(cliente)){
                cliente_na_lista = true;
                System.out.println(listaSinistro.get(i).toString());;
            }
        }
        if (cliente_na_lista == false){
            System.out.println("Cliente nao possui sinistro ou nome do cliente digitado errado");
        }
    }

    public void listarVeiculoPorCliente(String cliente){

        //Lista todos os veiculos de um cliente cadastrado na seguradora

        for (int i = 0; i < listaClientes.size(); i++){
            if (listaClientes.get(i).getNome().equals(cliente)){
                for (int j = 0; j < listaClientes.get(i).getListaVeiculos().size(); j++){
                    System.out.println(listaClientes.get(i).getListaVeiculos().toString());
                }
            }
        }
    }

    public void listarVeiculosPorSeguradora(){

        //Lista todos os veiculos de todos os clientes cadastrados na seguradora

        for (int i = 0; i < listaClientes.size(); i++){
            for (int j = 0; j < listaClientes.get(i).getListaVeiculos().size(); j++){
                System.out.println(listaClientes.get(i).getListaVeiculos().get(j).toString());
            }
        }
    }

    public void excluiVeiculo(String cliente, String placa){

        //Exclui um veiculo especifico de um cliente especifico

        for (int i = 0; i < listaClientes.size(); i++){
            if (listaClientes.get(i).getNome().equals(cliente)==true){
                for (int j = 0; j < listaClientes.get(i).getListaVeiculos().size(); j++){
                    if (listaClientes.get(i).getListaVeiculos().get(j).getPlaca().equals(placa)==true){
                        listaClientes.get(i).getListaVeiculos().remove(j);
                    }
                }
            }
        }
    }

    public void excluiSinistro(String nome){

        //Exclui todos os sinistros de um cliente

        for (int i = 0; i < listaSinistro.size(); i++){
            if(listaSinistro.get(i).getCliente().getNome().equals(nome)==true){
                listaSinistro.remove(i);
            }
        }
    }

    public void excluiCliente(String nome_cliente){

        //Exclui um cliente da listaCliente, removendo-o da seguradora

        for (int i = 0; i < listaClientes.size(); i++){
            if (listaClientes.get(i).getNome().equals(nome_cliente)==true){
                listaClientes.remove(i);
            }
        }
    }
    
    public double calcularPrecoSeguraCliente(String nomeCliente){

        //Calcula o valor de seguro de um cliente e vincula a ele

        double score = 0;
        Cliente c = null;
        for (int i = 0; i < listaClientes.size(); i++){
            if (listaClientes.get(i).getNome().equals(nomeCliente)==true){
                score = listaClientes.get(i).calculaScore();
                c = listaClientes.get(i);
            }
        }
        int numero_sinistros = 0;
        for (int j = 0; j < listaSinistro.size(); j++){
            if (listaSinistro.get(j).getCliente().getNome().equals(nomeCliente)==true){
                numero_sinistros++; 
            }
        }
        if (c != null){
            c.setValorSeguro(score * (1+numero_sinistros));
        };
        return score * (1+numero_sinistros);
    }

    public double calcularReceita(){

        //Calcula a receita todal da seguradora a partir dos valores de seguro de cada cliente

        double receita = 0;
        for (int i = 0; i < listaClientes.size(); i++){
            receita += listaClientes.get(i).getValorSeguro();
        }
        return receita;
    }

    public double transfereSeguro(String cliente1, String cliente2){

        //Tranfere todos os veiculos do cliente 1 para o cliente 2, recalcula o valor de seguro do cliente 2 e exclui o cliente 1 da seguradora

        Cliente c1 = null;
        Cliente c2 = null;
        //Transferindo o seguro do cliente 1 para o 2
        for (int i = 0; i < listaClientes.size(); i++){
            if(listaClientes.get(i).getNome().equals(cliente1)==true){
                c1 = listaClientes.get(i);
            }
            if(listaClientes.get(i).getNome().equals(cliente2)==true){
                c2 = listaClientes.get(i);
            } 
        }
        if(c1 != null && c2 != null){
            for (int i = 0; i < c1.getListaVeiculos().size(); i++){
                c2.adicionaVeiculo(c1.listaVeiculos.get(i));
            }
        }
        double novo_seguro_c2 = this.calcularPrecoSeguraCliente(cliente2);
        this.listaClientes.remove(c1);
        return novo_seguro_c2;
    }
}