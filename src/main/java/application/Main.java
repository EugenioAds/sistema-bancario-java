package application;

import entities.Conta;
import java.util.Scanner;
import services.Banco;

public class Main {


    public static void main(String[] args) {

        Conta conta1 = new Conta(
                1001,
                "Ernesto",
                500.0,
                "123.456.789-00"
        );
        Conta conta2 = new Conta(
                1002,
                "Maria",
                1200,
                "987.654.321-00"
        );
        Conta conta3 = new Conta(
                1003,
                "João",
                850,
                "111.222.333-44"
        );

        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n=======================");
            System.out.println("       BANCO DIGITAL");
            System.out.println("=========================");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Mostrar dados da conta");
            System.out.println("5 - Sair");
            System.out.println("6- Listar contas");
            System.out.println(" - Escolha uma opção");

            opcao = sc.nextInt();

            Banco banco = new Banco();
            banco.adicionarConta(conta1);
            banco.adicionarConta(conta2);
            banco.adicionarConta(conta3);

            Conta conta = conta1;


            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;

                 case 2:
                     System.out.println("Digite o valor do depósito: R$");
                     double valorDeposito = sc.nextDouble();
                     conta.depositar(valorDeposito);
                     System.out.println("Depósito realizado! Novo Saldo: R$" + conta.getSaldo());
                    break;

                case 3:
                    System.out.println("Digite o valor do saque: R$");
                    double valorSaque = sc.nextDouble();
                    conta.sacar(valorSaque);
                    System.out.println("Saque realizado! Novo Saldo: R$" + conta.getSaldo());
                    break;

                case 4: System.out.println("Saldo atual: R$" + conta.getSaldo());
                break;


                case 5:
                    System.out.println("Obrigado por utilizar nosso banco!");
                    break;

                case 6:
                    banco.listarContas();
                break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 5);

        System.out.println("Programa encerrado!");

        sc.close();



        }
    }

