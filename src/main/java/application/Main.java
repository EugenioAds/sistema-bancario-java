package application;

import entities.Conta;

public class Main {

    public static void main(String[] args) {

        Conta conta = new Conta(
                1001,
                "Ernesto",
                500.0,
                "123.456.789-00"

        );

        System.out.println("Conta criada com sucesso!");
        System.out.println("Número: " + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("CPF: " + conta.getCpf());
        System.out.println("Saldo: R$ " + conta.getSaldo());

        System.out.println("Saldo inicial: R$ " + conta.getSaldo());
        conta.depositar(300);
        System.out.println("Saldo após depósito: R$ " + conta.getSaldo());
        conta.sacar(150);
        System.out.println("Saldo após saque: R$ "+ conta.getSaldo());




        }
    }

