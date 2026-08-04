package entities;

public class Conta {


    private int numero;
    private String titular;
    private String cpf;
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


public void depositar(double valor) {
    if (valor > 0){
        saldo += valor;
    } else {
        System.out.println("Valor inválido para depósito");
    }
}

public void sacar(double valor) {
    if (valor <= 0) {
        System.out.println("Valor inválido para saque.");
    return;
    }

    if (valor > saldo) {
        System.out.println("Saldo insuficiente.");
        return;
    }
    saldo -= valor;
}
 public void consultarSaldo() {

     System.out.println("\n==========================");
     System.out.println("      DADOS DA CONTA");
     System.out.println("==========================");
     System.out.println("Titular: " + titular);
     System.out.println("CPF: " + cpf);
     System.out.println("Conta: " + numero);
     System.out.printf("Saldo: R$ %.2f%n", saldo);
     System.out.println("==========================");
 }
}

