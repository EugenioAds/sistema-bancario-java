package services;

import entities.Conta;
import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

        public void listarContas() {

            if (contas.isEmpty()) {
                System.out.println("Nenhuma conta cadastrada.");
                return;
            }
            System.out.println("\n==== CONTAS CADASTRADAS ====");

            for (Conta conta : contas) {

                System.out.println(
                        "Contas: " + conta.getNumero() +
                                "| Titular: " + conta.getTitular()
                );
            }
        }
    }








