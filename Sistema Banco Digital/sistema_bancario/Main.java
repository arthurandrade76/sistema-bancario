package sistema_bancario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ContaBancaria> contas = new ArrayList<>();

        contas.add(new ContaCorrente("1010", "Ana Silva", 500.0));
        contas.add(new ContaPoupanca("2020", "Carlos Souza", 2000.0));
        contas.add(new ContaSalario("3030", "Maria Oliveira", 1500.0));

        System.out.println("--- Rodando Rendimentos ---");
        for (ContaBancaria conta : contas) {
            double saldoAnterior = conta.getSaldo();
            conta.calcularRendimento();
            System.out.println("Titular: " + conta.getTitular() + 
                               " | Saldo Anterior: R$ " + saldoAnterior + 
                               " | Saldo Atual: R$ " + conta.getSaldo());
        }

        System.out.println("\n--- Provocando e Tratando Exceções ---");

        try {
            ContaBancaria cc = contas.get(0);
            System.out.println("Tentando sacar R$ 2000 da Conta Corrente...");
            cc.sacar(2000.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Capturado (Erro de Saldo): " + e.getMessage());
        } catch (OperacaoInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        try {
            ContaBancaria cp = contas.get(1);
            System.out.println("Bloqueando a conta de Carlos...");
            cp.bloquear();
            System.out.println("Tentando depositar R$ 100 na conta bloqueada...");
            cp.depositar(100.0);
        } catch (OperacaoInvalidaException e) {
            System.out.println("Capturado (Erro de Operação): " + e.getMessage());
        }
    }
}

