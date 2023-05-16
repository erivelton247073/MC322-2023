public class Validacao {

    private Validacao(){}; // construtor privado

    public static boolean validarCPF(String cpf){
        
        //Metodo para validar o CPF do cliente
        
        String cpfValidacao = cpf;
        //Primeiro vamos formatar o cpf
        cpfValidacao = cpfValidacao.replaceAll("\\D","");
        //conferindo se cpf possui 11 dígitos
        if (cpfValidacao.length() != 11){
            return false;
        }
        //conferindo se todos os dígitos são iguais
        Boolean todos_digitos_iguais = true;
        for (int i=1; i < cpfValidacao.length(); i++){
            if (cpfValidacao.charAt(0) != cpfValidacao.charAt(i)){
                todos_digitos_iguais = false;
            }     
        }
        if (todos_digitos_iguais == true){
            return false;
        }
        //separando os dígitos verificadores para teste
        String ultimosDigitos = cpfValidacao.substring(cpfValidacao.length() - 2);
        int digitos_verificadores = Integer.parseInt(ultimosDigitos);
        int digito_v1 = digitos_verificadores/10;
        int digito_v2 = digitos_verificadores%10;
        int soma1 = 0;
        int soma2 = 0;
        //realizando as operações necessárias para calcular os dígitos verificadores
        for (int i = 0, multiplicador = 10; i < 9; i++, multiplicador--){
            //Diminuindo 48 por causa da tabela ASCII
            int algarismo = cpfValidacao.charAt(i) - 48;
            soma1 += (algarismo*multiplicador);
        }
        int digito_v1_encontrado;
        if(soma1%11 != 0 && soma1%11 != 1){
            digito_v1_encontrado = 11 - (soma1%11);
        } else {
            digito_v1_encontrado = 0;
        }
        for (int i = 1, multiplicador = 10; i < 10; i++, multiplicador--){
            //Diminuindo 48 por causa da tabela ASCII
            int algarismo = cpfValidacao.charAt(i) - 48;
            soma2 += (algarismo*multiplicador);
        }
        int digito_v2_encontrado;
        if(soma2%11 != 0 && soma2%11 != 1){
            digito_v2_encontrado = 11 - (soma2%11);
        } else {
            digito_v2_encontrado = 0;
        }
        if (digito_v1 == digito_v1_encontrado && digito_v2 == digito_v2_encontrado){
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarCNPJ(String cnpj){

        //Método responsável por validar o cnpj

        String cnpjValidacao = cnpj;
        //Primeiro vamos formatar o cnpj deixando apenas os valores numéricos
        cnpjValidacao = cnpjValidacao.replaceAll("\\D","");
        String digitos_verificadores_string = cnpjValidacao.substring(cnpjValidacao.length() - 2);
        int digitos_verificadores = Integer.parseInt(digitos_verificadores_string);
        int digito_v1 = digitos_verificadores/10;
        int digito_v2 = digitos_verificadores%10;
        //esse String é arbritária pra validação do cnpj
        String lista_numeros_verificadores = ("543298765432");
        int soma = 0;
        for (int i = 0; i < 12; i++){
            //Diminuindo 48 por causa da tabela ASCII
            int algarismo = cnpjValidacao.charAt(i) - 48;
            int multiplicador = lista_numeros_verificadores.charAt(i) - 48;
            soma += (algarismo*multiplicador);
        }
        int primeiro_dig_verificador;
        if(soma%11 != 0 && soma%11 != 1){
            primeiro_dig_verificador = 11 - (soma%11);
        } else {
            primeiro_dig_verificador = 0;
        }
        lista_numeros_verificadores = ("6543298765432");
        soma = 0;
        for (int i = 0; i < 13; i++){
            //Diminuindo 48 por causa da tabela ASCII
            int algarismo = cnpjValidacao.charAt(i) - 48;
            int multiplicador = lista_numeros_verificadores.charAt(i) - 48;
            soma += (algarismo*multiplicador);
        }
        int segundo_dig_verificador;
        if(soma%11 != 0 && soma%11 != 1){
            segundo_dig_verificador = 11 - (soma%11);
        } else {
            segundo_dig_verificador = 0;
        }
        if (digito_v1 == primeiro_dig_verificador && digito_v2 == segundo_dig_verificador){
            return true;
        } else {
            return false;
        }
    }

    public static boolean validaNome(String nome){
        //usando a expressão regular "[a-zA-Z]+" para garantir que Nome é composto apenas por letras maiúsculas e minúsculas
        if (nome.matches("[a-zA-Z]+")==true){
            return true;
        } else {
            return false;
        }
    }
}
