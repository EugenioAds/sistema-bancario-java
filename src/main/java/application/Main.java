package application;

import entities.Conta;
import java.util.Scanner;
import services.Banco;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        double saldo;
        Conta conta1 = new Conta(
                1001,
                "Ernesto",
                500.0,
                "123.456.789-00"

        );

        Conta conta2 = new Conta(
                1002,
                "Maria",
                1200.0,
                "987.654.321-00"


        );

        Conta conta3 = new Conta(
                1003,
                "João",
                850.0,
                "111.222.333-44"

        );

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        Banco banco = new Banco();

        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);
        banco.adicionarConta(conta3);

        Conta conta = conta1;

        int opcao;

        do {

            System.out.println("\n=======================");
            System.out.println("       BANCO DIGITAL");
            System.out.println("=======================");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Mostrar dados da conta");
            System.out.println("5 - Sair");
            System.out.println("6 - Listar contas");
            System.out.println("7 - Selecionar conta");
            System.out.println("8 - Criar nova conta");
            System.out.println("-----------------------");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:

                    System.out.println("Saldo atual: R$ " + conta.getSaldo());

                    break;

                case 2:

                    System.out.print("Digite o valor do depósito: R$ ");
                    double valorDeposito = sc.nextDouble();

                    conta.depositar(valorDeposito);

                    System.out.println(
                            "Depósito realizado! Novo saldo: R$ "
                                    + conta.getSaldo()
                    );

                    break;

                case 3:

                    System.out.print("Digite o valor do saque: R$ ");
                    double valorSaque = sc.nextDouble();

                    conta.sacar(valorSaque);

                    System.out.println(
                            "Saque realizado! Novo saldo: R$ "
                                    + conta.getSaldo()
                    );

                    break;

                case 4:

                    System.out.println(conta.consultarDados());

                    break;

                case 5:

                    System.out.println("Obrigado por utilizar nosso banco!");

                    break;

                case 6:

                    banco.listarContas();

                    break;

                case 7:

                    System.out.print("Digite o número da conta: ");
                    int numeroConta = sc.nextInt();

                    Conta contaEncontrada = banco.buscarConta(numeroConta);

                    if (contaEncontrada != null) {

                        conta = contaEncontrada;

                        System.out.println("Conta selecionada com sucesso!");
                        System.out.println("Titular: " + conta.getTitular());
                        System.out.println("Saldo: R$ " + conta.getSaldo());

                    } else {

                        System.out.println("Conta não encontrada.");

                    }

                    break;

                case 8:

                    System.out.print("Número da conta: ");
                    int numero = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Titular: ");
                    String titular = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Saldo inicial: ");
                    saldo = sc.nextDouble();

                    Conta novaConta = new Conta(
                            numero,
                            titular,
                            saldo,
                            cpf

                    );

                    banco.cadastrarConta(novaConta);

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        System.out.println("Programa encerrado!");

        sc.close();
    }
}