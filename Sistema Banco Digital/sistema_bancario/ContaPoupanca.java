package sistema_bancario;

public class ContaPoupanca extends ContaBancaria implements Tributavel {
    
    public ContaPoupanca(String numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }

    @Override
    public void calcularRendimento() {
        double rendimento = this.saldo * 0.005;
        double impostoSobreRendimento = rendimento * 0.225;
        this.saldo += (rendimento - impostoSobreRendimento);
    }

    @Override
    public double calcularImposto() {
        return (this.saldo * 0.005) * 0.225;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException, SaldoInsuficienteException {
        super.sacar(valor);
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente na Conta Poupança.");
        }
        this.saldo -= valor;
    }
}