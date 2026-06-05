package sistema_bancario;

public class ContaCorrente extends ContaBancaria implements Tributavel {
    private double limiteChequeEspecial = 1000.00;

    public ContaCorrente(String numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }

    @Override
    public void calcularRendimento() {
    }

    @Override
    public double calcularImposto() {
        return 0.0;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException, SaldoInsuficienteException {
        super.sacar(valor);
        double imposto = valor * 0.0038;
        double valorTotalNecessario = valor + imposto;

        if (this.saldo + limiteChequeEspecial < valorTotalNecessario) {
            throw new SaldoInsuficienteException("Saldo e limite insuficientes para o saque com imposto.");
        }
        this.saldo -= valorTotalNecessario;
    }
}
