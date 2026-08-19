package services;

import entities.Conta;
import exceptions.ContaException;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private final List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        cadastrarConta(conta);
    }

    public void cadastrarConta(Conta conta) {
        validarConta(conta);

        if (buscarConta(conta.getNumero()) != null) {
            throw new ContaException("Já existe uma conta com esse número.");
        }

        contas.add(conta);
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        System.out.println("\n==== CONTAS CADASTRADAS ====");
        for (Conta conta : contas) {
            System.out.printf(
                    "Conta: %d | Titular: %s | Saldo: R$ %.2f%n",
                    conta.getNumero(),
                    conta.getTitular(),
                    conta.getSaldo()
            );
        }
    }

    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }

        return null;
    }

    private void validarConta(Conta conta) {
        if (conta == null) {
            throw new ContaException("A conta não pode ser nula.");
        }
        if (conta.getNumero() <= 0) {
            throw new ContaException("O número da conta deve ser positivo.");
        }
        if (conta.getTitular() == null || conta.getTitular().isBlank()) {
            throw new ContaException("O titular da conta é obrigatório.");
        }
        if (conta.getCpf() == null || conta.getCpf().isBlank()) {
            throw new ContaException("O CPF é obrigatório.");
        }
        if (conta.getSaldo() < 0) {
            throw new ContaException("O saldo inicial não pode ser negativo.");
        }
    }
}
