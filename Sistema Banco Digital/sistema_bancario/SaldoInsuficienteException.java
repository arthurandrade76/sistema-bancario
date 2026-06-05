package sistema_bancario;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

