package sistema_bancario;

public class ContaSalario extends ContaBancaria {
    private int saquesNoMes = 0;

    public ContaSalario(String numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }

    @Override
    public void calcularRendimento() {
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException, SaldoInsuficienteException {
        super.sacar(valor);
        if (saquesNoMes >= 1) {
            throw new OperacaoInvalidaException("Limite de 1 saque por mês atingido para Conta Salário.");
        }
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente na Conta Salário.");
        }
        this.saldo -= valor;
        saquesNoMes++;
    }
}
