package application;

import entities.Conta;
import exceptions.ContaException;
import services.Banco;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        Banco banco = new Banco();
        banco.adicionarConta(new Conta(1001, "Ernesto", 500.0, "123.456.789-00"));
        banco.adicionarConta(new Conta(1002, "Maria", 1200.0, "987.654.321-00"));
        banco.adicionarConta(new Conta(1003, "João", 850.0, "111.222.333-44"));

        Conta contaSelecionada = banco.buscarConta(1001);
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro(sc, "Escolha uma opção: ");

            switch (opcao) {
                case 1 -> System.out.printf("Saldo atual: R$ %.2f%n", contaSelecionada.getSaldo());

                case 2 -> {
                    double valor = lerValor(sc, "Digite o valor do depósito: R$ ");
                    if (contaSelecionada.depositar(valor)) {
                        System.out.printf("Depósito realizado! Novo saldo: R$ %.2f%n", contaSelecionada.getSaldo());
                    } else {
                        System.out.println("O valor do depósito deve ser maior que zero.");
                    }
                }

                case 3 -> {
                    double valor = lerValor(sc, "Digite o valor do saque: R$ ");
                    if (contaSelecionada.sacar(valor)) {
                        System.out.printf("Saque realizado! Novo saldo: R$ %.2f%n", contaSelecionada.getSaldo());
                    } else {
                        System.out.println("Valor inválido ou saldo insuficiente.");
                    }
                }

                case 4 -> System.out.println(contaSelecionada.consultarDados());

                case 5 -> System.out.println("Obrigado por utilizar nosso banco!");

                case 6 -> banco.listarContas();

                case 7 -> {
                    int numero = lerInteiro(sc, "Digite o número da conta: ");
                    Conta contaEncontrada = banco.buscarConta(numero);

                    if (contaEncontrada == null) {
                        System.out.println("Conta não encontrada.");
                    } else {
                        contaSelecionada = contaEncontrada;
                        System.out.println("Conta selecionada com sucesso!");
                    }
                }

                case 8 -> {
                    int numero = lerInteiro(sc, "Número da conta: ");
                    System.out.print("Titular: ");
                    String titular = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    double saldo = lerValor(sc, "Saldo inicial: ");

                    try {
                        Conta novaConta = new Conta(numero, titular, saldo, cpf);
                        banco.cadastrarConta(novaConta);
                        contaSelecionada = novaConta;
                        System.out.println("Conta cadastrada e selecionada com sucesso!");
                    } catch (ContaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        System.out.println("Programa encerrado!");
        sc.close();
    }

    private static void exibirMenu() {
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
    }

    private static int lerInteiro(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = sc.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerValor(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = sc.nextLine().trim().replace(',', '.');

            try {
                double valor = Double.parseDouble(entrada);
                if (Double.isFinite(valor)) {
                    return valor;
                }
            } catch (NumberFormatException ignored) {
                // A mensagem abaixo orienta o usuário sem expor detalhes da conversão.
            }

            System.out.println("Digite um valor numérico válido.");
        }
    }
}
