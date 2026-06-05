package sistema_bancario;

public interface Bloqueavel {
    void bloquear();
    void desbloquear();
    boolean isAtiva();
}

