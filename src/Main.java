public class Main {

    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente("Erivelton", "280.012.389-38", "30/03/2002", 21, "KFF");
        Veiculo carro1 = new Veiculo("TEST3", "BMW", "Alberto");
        Seguradora seguro1 = new Seguradora("Acidente_rodovia", "XX-XXXX-XXXX", "testando@testemail.com", "KFF");
        Sinistro sinistro1 = new Sinistro("14/02/2024", "Rua Albert Eisten");
        //Conferindo se as informações foram devidamente registradas e verificando o método validaCpf com 4 exemplos distintos de cpf
        System.out.println(cliente1.getNome());
        System.out.println(cliente1.getCpf());
        cliente1.validarCPF();
        System.out.println(cliente1.getDataNascimento());
        System.out.println(cliente1.getIdade());
        System.out.println(carro1.getPlaca());
        System.out.println(carro1.getMarca());
        System.out.println(carro1.getModelo());
        System.out.println(seguro1.getNome());
        System.out.println(seguro1.getTelefone());
        System.out.println(seguro1.getEmail());
        System.out.println(seguro1.getEndereco());
        System.out.println(sinistro1.getData());
        System.out.println(sinistro1.getId());
        System.out.println(sinistro1.getEndereco());
        cliente1.setCpf("222.222.222-22");
        System.out.println(cliente1.getCpf());
        cliente1.validarCPF();
        cliente1.setCpf("280.012.389-39");
        System.out.println(cliente1.getCpf());
        cliente1.validarCPF();
        cliente1.setCpf("245.2672.23-12");
        System.out.println(cliente1.getCpf());
        cliente1.validarCPF();
    }    
}
