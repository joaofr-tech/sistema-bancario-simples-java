package model;

public class Conta {
    private int numero;
    public String titular;
    public double saldo;

    public Conta(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void depositar(double valor){

        if (valor < 0){
            throw new IllegalArgumentException("Digite um valor positivo");
        }

        this.saldo += valor;
    }

    public void sacar(double valor){

        if (valor < 0){
            throw new IllegalArgumentException("Digite um valor positivo");
        }


        if (this.saldo < valor){
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        this.saldo -= valor;
    }

    public void transferir(){}

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }


}
