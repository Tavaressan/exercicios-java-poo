import Models.Carro;
import java.util.Scanner;

public class MenuCarro {
        private static final Scanner scanner = new Scanner(System.in);
        private static Carro carro;

        public static void main(String[] args) {
            System.out.println("Bem vindo ao seu carro!");

            System.out.println("Qual é o nome do seu carro mesmo?");
            String nome = scanner.next();

            carro = new Carro(nome);

            boolean menu = true;
            while (menu) {
                MostrarMenu();
                String acao = scanner.next();
                switch (acao) {
                    case "1" -> carro.LigarCarro();
                    case "2" -> carro.DesligarCarro();
                    case "3" -> carro.AumentarMarcha();
                    case "4" -> carro.DiminuirMarcha();
                    case "5" -> {
                        System.out.println("Quantas vezes deseja acelerar?");
                        int vezes = scanner.nextInt();
                        carro.AcelerarCarro(vezes);
                    }
                    case "6" -> {
                        System.out.println("Quantas vezes deseja desacelerar?");
                        int vezes = scanner.nextInt();
                        carro.DesacelerarCarro(vezes);
                    }
                    case "7" -> carro.VerificarVelocidade();
                    case "8" -> carro.VirarEsquerda();
                    case "9" -> carro.VirarDireita();
                    case "0" -> {
                        menu = false;
                        System.out.println("Ações encerradas");
                    }
                    default -> System.out.println("Ação inválida, por favor escolha uma ação válida");
                }
            }
        }


    public static void MostrarMenu() {
        System.out.println("\nEscolha uma ação para fazer em seu carro:");
        System.out.println("1 - Ligar carro");
        System.out.println("2 - Desligar carro");
        System.out.println("3 - Aumentar marcha");
        System.out.println("4 - Diminuir marcha");
        System.out.println("5 - Acelerar carro");
        System.out.println("6 - Desacelerar carro");
        System.out.println("7 - Verificar velocidade");
        System.out.println("8 - Virar à esquerda");
        System.out.println("9 - Virar à direita");
        System.out.println("0 - Sair");
    }
}
