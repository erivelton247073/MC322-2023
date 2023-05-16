public enum MenuOperacoes {

    /*Classe enum que auxilia no menu interativo */

    Sair(0),
    Cadastros(1),
    Listar(2),
    Excluir(3),
    gerarSinistro(4),
    TransferirSeguro(5),
    CalcularReceitaSeguradora(6),
    CadastrarClientePF_PF(11),
    CadastrarVeiculo(12),
    CadastrarSeguradora(14),
    VoltarCadastro(14),
    ListarCliente(21),
    ListarSinistroPorSeguradora(22),
    ListarSinistroPorCliente(23),
    ListarVeiculoPorCliente(24),
    ListarVeiculoPorSeguradora(25),
    VoltarSeguradora(26),
    ExcluirCliente(31),
    ExcluirVeiculo(32),
    ExcluirSinistro(33),
    VoltarExcluir(34);

    final double operacoes;

    MenuOperacoes(double operacoes){
        this.operacoes = operacoes;
    }

    public double getOperacao(){
        return this.operacoes;
    }
}
