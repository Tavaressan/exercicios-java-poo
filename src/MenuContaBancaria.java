import Models.ContaBancaria;
import java.util.Scanner;

public class MenuContaBancaria {
    private static final Scanner scanner = new Scanner(System.in);
    private static ContaBancaria conta;

    public static void main(String[] args) {
        System.out.println("Bem vindo ao sistema de Conta Bancária!");

        System.out.println("Qual é o seu nome?");
        var nome = scanner.next();

        System.out.println("Qual é o saldo inicial da sua conta?");
        var saldo = scanner.nextDouble();

        conta = new ContaBancaria(nome, saldo);

        boolean menu = true;
        while (menu) {
            exibirMenu();
            String operacao = scanner.next();

            switch (operacao) {
                case "1" -> conta.ConsultarSaldo();
                case "2" -> realizarDeposito();
                case "3" -> realizarSaque();
                case "4" -> conta.ConsultarChequeEspecial();
                case "5" -> pagarBoleto();
                case "6" -> conta.VerificaUsoChequeEspecial();
                case "0" -> {
                    menu = false;
                    System.out.println("Operações encerradas.");
                }
                default -> System.out.println("Operação inválida! Por favor, escolha uma opção válida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nEscolha uma operação:");
        System.out.println("1 - Verificar saldo");
        System.out.println("2 - Depositar dinheiro");
        System.out.println("3 - Sacar dinheiro");
        System.out.println("4 - Consultar cheque especial");
        System.out.println("5 - Pagar boleto");
        System.out.println("6 - Verificar uso do cheque especial");
        System.out.println("0 - Sair");
    }

    private static void realizarDeposito() {
        System.out.println("Quanto deseja depositar?");
        double valor = scanner.nextDouble();
        conta.DepositarDinheiro(valor);
    }

    private static void realizarSaque() {
        System.out.println("Quanto deseja sacar?");
        double valor = scanner.nextDouble();
        conta.SacarDinheiro(valor);
    }

    private static void pagarBoleto() {
        System.out.println("Qual o valor do boleto?");
        double valor = scanner.nextDouble();
        conta.PagarBoleto(valor);
    }
}

// Primeiro Menu criado para esta solução
//import Models.ContaBancaria;
//
//import java.util.Scanner;
//
//public class App {
//    public static void main(String[] args) {
//
//        var scanner = new Scanner(System.in);
//        System.out.println("Bem vindo ao sistema de Conta Bancária!");
//
//        System.out.println("Qual é o seu nome?");
//        var nome = scanner.next();
//
//        System.out.println("Qual é o saldo inicial da sua conta?");
//        var saldo = scanner.nextDouble();
//
//        ContaBancaria conta = new ContaBancaria(nome, saldo);
//
//
//        var menu = true;
//        while (menu) {
//            System.out.println("Qual operação você quer fazer?");
//            System.out.println("1 - Verificar saldo\n2 - Depositar dinheiro\n3 - Sacar dinheiro\n4 - Consultar cheque especial\n5 - Pagar boleto\n6 - Verificar uso do cheque especial");
//            String operacao = scanner.next();
//
//            switch (operacao) {
//                case "1" -> {
//                    conta.ConsultarSaldo();
//                    System.out.println("Qual operação você quer fazer?");
//                    operacao = scanner.next();
//                }
//                case "2" -> {
//                    System.out.println("Quanto deseja depositar?");
//                    double valor = scanner.nextDouble();
//                    conta.DepositarDinheiro(valor);
//                    System.out.println("Qual operação você quer fazer?");
//                    operacao = scanner.next();
//                }
//                case "3" -> {
//                    System.out.println("Quanto deseja sacar?");
//                    double valor = scanner.nextDouble();
//                    conta.SacarDinheiro(valor);
//                    System.out.println("Qual operação você quer fazer?");
//                    operacao = scanner.next();
//                }
//                case "4" -> {
//                    conta.ConsultarChequeEspecial();
//                    System.out.println("Qual operação você quer fazer?");
//                    operacao = scanner.next();
//                }
//                case "5" -> {
//                    System.out.println("Qual o valor do boleto?");
//                    double valor = scanner.nextDouble();
//                    conta.PagarBoleto(valor);
//                    System.out.println("Qual operação você quer fazer?");
//                    operacao = scanner.next();
//                }
//                case "6" -> {
//                    conta.VerificaUsoChequeEspecial();
//                    System.out.println("Qual operação você quer fazer?");
//                    operacao = scanner.next();
//                }
//                case "0" -> {
//                    menu = false;
//                    System.out.println("Operações encerradas.");
//                }
//                default -> System.out.println("Esta operação não é válida.");
//            }
//        }
//    }
//}




















//        var c1 = new ContaBancaria("Vitor", 1000 );
//        System.out.println("Saldo");
//        c1.ConsultarSaldo();
//        System.out.println("<==================>");
//        System.out.println("Depósito");
//        c1.DepositarDinheiro(500);
//        System.out.println("<==================>");
//        System.out.println("Saldo");
//        c1.ConsultarSaldo();
//        System.out.println("<==================>");
//        System.out.println("Saque");
//        c1.SacarDinheiro(500);
//        System.out.println("<==================>");
//        System.out.println("Consulta cheque especial");
//        c1.ConsultarChequeEspecial();
//        System.out.println("<==================>");
//        System.out.println("Paga boleto");
//        c1.PagarBoleto(1500);
//        System.out.println("<==================>");
//        System.out.println("Verifica uso do cheque especial");
//        c1.VerificaUsoChequeEspecial();
//        System.out.println("<==================>");
//        System.out.println("Saldo");
//        c1.ConsultarSaldo();
//        System.out.println("<==================>");
//    }
//}
