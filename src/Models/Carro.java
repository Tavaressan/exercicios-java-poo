package Models;

public class Carro {
    private final String nomeCarro;
    private Integer marcha = 0;
    private Integer velocidade = 0;
    private Boolean estaLigado = false;

    public Carro(String nome) {
        nomeCarro = nome;
    }

    public void LigarCarro() {
        if (estaLigado) {
            System.out.println("Carro já está ligado");
        } else {
            estaLigado = true;
            System.out.println("Você ligou o carro");
        }
    }

    public void DesligarCarro() {
        if (!estaLigado) {
            System.out.println("Carro já está desligado");
        } else if (velocidade == 0 && marcha == 0) {
            estaLigado = false;
            System.out.println("Você desligou o carro");
        } else {
            System.out.println("Você não pode desligar o carro em movimento!");
        }
    }

     public void AcelerarCarro(int vezes) {
            if (!estaLigado) {
                System.out.println("O carro precisa estar ligado para acelerar");
                return;
            }

            for (int i = 0; i < vezes; i++) {
                if (marcha == 0) {
                    System.out.println("Você não pode acelerar na marcha 0");
                    break;
                } else if (marcha == 1 && velocidade >= 20) {
                    System.out.println("Você não pode acelerar mais do que 20 km/h na primeira marcha");
                    break;
                } else if (marcha == 2 && velocidade >= 40) {
                    System.out.println("Você não pode acelerar mais do que 40 km/h na segunda marcha");
                    break;
                } else if (marcha == 3 && velocidade >= 60) {
                    System.out.println("Você não pode acelerar mais do que 60 km/h na terceira marcha");
                    break;
                } else if (marcha == 4 && velocidade >= 80) {
                    System.out.println("Você não pode acelerar mais do que 80 km/h na quarta marcha");
                    break;
                } else if (marcha == 5 && velocidade >= 100) {
                    System.out.println("Você não pode acelerar mais do que 100 km/h na quinta marcha");
                    break;
                } else if (marcha == 6 && velocidade >= 120) {
                    System.out.println("Você não pode acelerar acima de 120 km/h");
                    break;
                } else {
                    velocidade++;
                    System.out.println("Velocidade atual: " + velocidade + " km/h");
                }
            }
        }
    public void DesacelerarCarro(int vezes) {
            if (!estaLigado) {
                System.out.println("O carro precisa estar ligado para desacelerar");
                return;
            }

            for (int i = 0; i < vezes; i++) {
                if (velocidade == 0) {
                    System.out.println("O carro já está parado");
                    break;
                } else if (marcha == 2 && velocidade <= 21) {
                    System.out.println("Você precisa reduzir a marcha para desacelerar abaixo de 21 km/h");
                    break;
                } else if (marcha == 3 && velocidade <= 41) {
                    System.out.println("Você precisa reduzir a marcha para desacelerar abaixo de 41 km/h");
                    break;
                } else if (marcha == 4 && velocidade <= 61) {
                    System.out.println("Você precisa reduzir a marcha para desacelerar abaixo de 61 km/h");
                    break;
                } else if (marcha == 5 && velocidade <= 81) {
                    System.out.println("Você precisa reduzir a marcha para desacelerar abaixo de 81 km/h");
                    break;
                } else if (marcha == 6 && velocidade <= 101) {
                    System.out.println("Você precisa reduzir a marcha para desacelerar abaixo de 101 km/h");
                    break;
                } else {
                    velocidade--;
                    System.out.println("Velocidade atual: " + velocidade + " km/h");
                }
            }
    }

    public void AumentarMarcha() {
        if (!estaLigado) {
            System.out.println("O carro precisa estar ligado para mudar a marcha");
            return;
        }

        if (marcha >= 6) {
            System.out.println("Você já está na última marcha");
        } else if (marcha == 0 && velocidade == 0) {
            marcha++;
            System.out.println("Você colocou a primeira marcha");
        } else if (velocidade >= 20 && marcha == 1) {
            marcha++;
            System.out.println("Você aumentou para a segunda marcha");
        } else if (velocidade >= 40 && marcha == 2) {
            marcha++;
            System.out.println("Você aumentou para a terceira marcha");
        } else if (velocidade >= 60 && marcha == 3) {
            marcha++;
            System.out.println("Você aumentou para a quarta marcha");
        } else if (velocidade >= 80 && marcha == 4) {
            marcha++;
            System.out.println("Você aumentou para a quinta marcha");
        } else if (velocidade >= 100 && marcha == 5) {
            marcha++;
            System.out.println("Você aumentou para a sexta marcha");
        } else {
            System.out.println("Velocidade insuficiente para aumentar a marcha");
        }
    }

    public void DiminuirMarcha() {
        if (!estaLigado) {
            System.out.println("O carro precisa estar ligado para mudar a marcha");
            return;
        }

        if (marcha <= 0) {
            System.out.println("Você já está em ponto morto");
        } else if (velocidade <= 20 && marcha > 1) {
            marcha--;
            System.out.println("Você reduziu a marcha");
        } else if (velocidade <= 40 && marcha > 2) {
            marcha--;
            System.out.println("Você reduziu a marcha");
        } else if (velocidade <= 60 && marcha > 3) {
            marcha--;
            System.out.println("Você reduziu a marcha");
        } else if (velocidade <= 80 && marcha > 4) {
            marcha--;
            System.out.println("Você reduziu a marcha");
        } else if (velocidade <= 100 && marcha > 5) {
            marcha--;
            System.out.println("Você reduziu a marcha");
        } else if (velocidade == 0) {
            marcha--;
            System.out.println("Você colocou em ponto morto");
        } else {
            System.out.println("Velocidade muito alta para reduzir a marcha");
        }
    }

    public void VirarEsquerda() {
        if (!estaLigado) {
            System.out.println("O carro precisa estar ligado para virar");
        } else if (velocidade == 0) {
            System.out.println("Você não pode virar enquanto o carro está parado");
        } else if (velocidade >= 40) {
            System.out.println("Você não pode virar o carro acima de 40km/h, é perigoso!");
        } else {
            System.out.println("Você virou à esquerda");
        }
    }

    public void VirarDireita() {
        if (!estaLigado) {
            System.out.println("O carro precisa estar ligado para virar");
        } else if (velocidade == 0) {
            System.out.println("Você não pode virar enquanto o carro está parado");
        } else if (velocidade >= 40) {
            System.out.println("Você não pode virar o carro acima de 40km/h, é perigoso!");
        } else {
            System.out.println("Você virou à direita");
        }
    }

    public void VerificarVelocidade() {
        System.out.println("Seu " + nomeCarro + " está a " + velocidade + " km/h");
    }
}