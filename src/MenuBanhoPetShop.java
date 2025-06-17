import Models.BanhoPetShop;
import java.util.Scanner;

// Menu implementado com otimização do Copilot

public class MenuBanhoPetShop {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bem vindo ao Sistema de Banho do Pet Shop!");
            BanhoPetShop banho = inicializarBanho(scanner);
            executarMenu(banho, scanner);
        }
    }

    private static BanhoPetShop inicializarBanho(Scanner scanner) {
        System.out.println("Qual é o nome do seu pet?");
        String nome = "";
        while (nome.trim().isEmpty()) {
            nome = scanner.nextLine();
            if (nome.trim().isEmpty()) {
                System.out.println("Por favor, digite um nome válido:");
            }
        }
        return new BanhoPetShop(nome);
    }

    private static void executarMenu(BanhoPetShop banho, Scanner scanner) {
        boolean menu = true;
        while (menu) {
            mostrarMenu();
            menu = processarOpcaoMenu(scanner.nextLine(), banho);
        }
    }

    private static boolean processarOpcaoMenu(String acao, BanhoPetShop banho) {
        return switch (acao) {
            case "1" -> { banho.colocarPetNaMaquina(); yield true; }
            case "2" -> { banho.retirarPetDaMaquina(); yield true; }
            case "3" -> { banho.verificarSeTemPetNoBanho(); yield true; }
            case "4" -> { banho.abastecerMaquinaComAgua(); yield true; }
            case "5" -> { banho.abastecerMaquinaComShampoo(); yield true; }
            case "6" -> { banho.verificarNivelDaAgua(); yield true; }
            case "7" -> { banho.verificarNivelDeShampoo(); yield true; }
            case "8" -> { banho.darBanhoNoPet(); yield true; }
            case "9" -> { banho.limparMaquina(); yield true; }
            case "0" -> {
                System.out.println("Sistema encerrado");
                yield false;
            }
            default -> {
                System.out.println("Ação inválida, por favor escolha uma ação válida");
                yield true;
            }
        };
    }

    private static void mostrarMenu() {
        System.out.println("\nEscolha uma ação para fazer:");
        System.out.println("1 - Colocar pet na máquina");
        System.out.println("2 - Retirar pet da máquina");
        System.out.println("3 - Verificar se tem pet no banho");
        System.out.println("4 - Abastecer máquina com água");
        System.out.println("5 - Abastecer máquina com shampoo");
        System.out.println("6 - Verificar nível da água");
        System.out.println("7 - Verificar nível do shampoo");
        System.out.println("8 - Dar banho no pet");
        System.out.println("9 - Limpar máquina");
        System.out.println("0 - Sair");
    }
}

