package service;

import model.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoService {
    List<Conta> contas = new ArrayList<>();
    private int proximoNumero = 1;

    public void criarConta(String nome, double saldo) {
        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Preencha nome");
        }
        if (saldo < 0){
            throw new IllegalArgumentException("Preencha saldo");
        }

        Conta conta = new Conta(proximoNumero, nome, saldo);
        proximoNumero++;
        contas.add(conta);

    }

    public void listarContas(){

        if (contas.isEmpty()){
            System.out.println();
            System.out.println("Nenhuma conta cadastrada");
            System.out.println();
            return;
        }

        for (Conta conta: contas){
            System.out.println(conta);
        }
    }

    public void depositar(int escolha, double valorDeposito){

        if (valorDeposito < 0){
            throw new IllegalArgumentException("Digite um valor positivo");
        }

        for (Conta conta : contas){
            if (conta.getNumero() == escolha){
                conta.depositar(valorDeposito);
            }
        }
    }

    public List<Conta> getContas() {
        return contas;
    }
}
