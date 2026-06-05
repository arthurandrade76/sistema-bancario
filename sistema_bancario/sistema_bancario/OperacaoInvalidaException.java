package sistema_bancario;

public class OperacaoInvalidaException extends Exception {
    public OperacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}
