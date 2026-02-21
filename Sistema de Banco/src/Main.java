import service.BancoService;

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
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1){
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Saldo: ");
                double saldo = scanner.nextDouble();

                try{
                    bancoService.criarConta(nome, saldo);
                } catch (IllegalArgumentException e){
                    System.out.println();
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            if (escolha == 2){
                bancoService.listarContas();
            }

            if (escolha == 3){
                bancoService.listarContas();
                System.out.print("Numero da conta: ");
                int escolhaDeposito = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Valor a depositar:");
                int valorDeposito = scanner.nextInt();
                scanner.nextLine();

                bancoService.depositar(escolhaDeposito, valorDeposito);
            }

            if (escolha == 6){
                break;
            }
        }
    }
}