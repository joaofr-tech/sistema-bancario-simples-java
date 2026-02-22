import service.BancoService;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

import static utils.PrintMenu.printarMenu;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BancoService bancoService = new BancoService();
        scanner.useLocale(new Locale("pt", "BR"));

        while (true){
            printarMenu();
            String escolha = scanner.nextLine();

            int opcao = 0;
            try {
                opcao = Integer.parseInt(escolha);
            } catch (NumberFormatException e){
                System.out.println();
                System.out.println("Erro: Digite um numero");
                System.out.println();
            }

            if (opcao == 1){
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Saldo: ");
                double saldo = scanner.nextDouble();
                scanner.nextLine();

                try{
                    bancoService.criarConta(nome, saldo);
                } catch (IllegalArgumentException e){
                    System.out.println();
                    System.out.println("Erro: " + e.getMessage());
                    System.out.println();
                }
            }

            if (opcao == 2){
                bancoService.listarContas();
            }

            if (opcao == 3){

                    bancoService.listarContas();

                    System.out.print("Numero da conta: ");
                    int escolhaDeposito = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Valor a depositar:");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();

                    try {
                        bancoService.depositar(escolhaDeposito, valorDeposito);
                    } catch (IllegalArgumentException e) {
                        System.out.println();
                        System.out.println("Erro: " + e.getMessage());
                        System.out.println();
                    }
            }

            if (opcao == 4){

                    bancoService.listarContas();

                    System.out.print("Numero da conta: ");
                    int escolhaDeposito = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Valor a sacar:");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();

                    try {
                        bancoService.sacar(escolhaDeposito, valorSaque);
                    } catch (IllegalArgumentException e) {
                        System.out.println();
                        System.out.println("Erro: " + e.getMessage());
                        System.out.println();
                    }
            }

            if (opcao == 6){
                break;
            }
        }
    }
}