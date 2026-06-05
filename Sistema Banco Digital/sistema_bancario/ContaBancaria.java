package sistema_bancario;

public abstract class ContaBancaria implements Bloqueavel {
    private String numero;
    private String titular;
    protected double saldo;
    private boolean ativa;

    public ContaBancaria(String numero, String titular, double saldoInicial) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("O titular não pode ser nulo ou vazio.");
        }
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.ativa = true;
    }

    public abstract void calcularRendimento();

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (!isAtiva()) {
            throw new OperacaoInvalidaException("Não é permitido depositar em conta bloqueada.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException, SaldoInsuficienteException {
        if (!isAtiva()) {
            throw new OperacaoInvalidaException("Não é permitido sacar de uma conta bloqueada.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser maior que zero.");
        }
    }

    @Override
    public void bloquear() { 
        this.ativa = false; 
    }

    @Override
    public void desbloquear() { 
        this.ativa = true; 
    }

    @Override
    public boolean isAtiva() { 
        return this.ativa; 
    }

    public String getNumero() { 
        return numero; 
    }
    
    public String getTitular() { 
        return titular; 
    }
    
    public double getSaldo() { 
        return saldo; 
    }
}
