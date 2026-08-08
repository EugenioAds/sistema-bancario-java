package services;

import entities.Conta;
import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void cadastrarConta(Conta conta) {

        if (buscarConta(conta.getNumero()) != null) {
            System.out.println("Erro: já existe uma conta com esse número.");
            return;

        }
        if (conta.getSaldo() < 0) {
            System.out.println("Erro: o saldo inicial não pode ser negativo");
            return;
        }

        contas.add(conta);

        System.out.println("Conta cadastrada com sucesso!");

    }

    public void listarContas() {

        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        System.out.println("\n==== CONTAS CADASTRADAS ====");

        for (Conta conta : contas) {

            System.out.println(
                    "Conta: " + conta.getNumero() +
                            " | Titular: " + conta.getTitular()
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
}