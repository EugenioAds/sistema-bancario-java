package entities;

public class Conta {

    private final int numero;
    private final String titular;
    private final String cpf;
    private double saldo;

    public Conta(int numero, String titular, double saldo, String cpf) {
        this.numero = numero;
        this.titular = titular;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean depositar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) {
            return false;
        }

        saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0 || valor > saldo) {
            return false;
        }

        saldo -= valor;
        return true;
    }

    public String consultarDados() {
        return String.format(
                "\n==========================%n" +
                "      DADOS DA CONTA%n" +
                "==========================%n" +
                "Titular: %s%n" +
                "CPF: %s%n" +
                "Conta: %d%n" +
                "Saldo: R$ %.2f%n" +
                "==========================",
                titular, cpf, numero, saldo
        );
    }
}
