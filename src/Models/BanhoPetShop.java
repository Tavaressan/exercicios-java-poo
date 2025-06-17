package Models;

/**
 * Classe que gerencia o banho de pets em uma máquina automatizada.
 */
public class BanhoPetShop {
    private static final int MAX_LITROS_AGUA = 30;
    private static final int MAX_LITROS_SHAMPOO = 10;
    private static final int AGUA_NECESSARIA_BANHO = 10;
    private static final int SHAMPOO_NECESSARIO_BANHO = 2;
    private static final int AGUA_NECESSARIA_LIMPEZA = 3;
    private static final int SHAMPOO_NECESSARIO_LIMPEZA = 1;

    private final String nomePet;
    private boolean petEstaLimpo;
    private boolean maquinaEstaLimpa;
    private boolean petEstaNaMaquina;
    private int litrosAguaNaMaquina;
    private int litrosShampooNaMaquina;

    public BanhoPetShop(String nome) {
        this.nomePet = nome;
        this.petEstaLimpo = false;
        this.maquinaEstaLimpa = true;
        this.petEstaNaMaquina = false;
        this.litrosAguaNaMaquina = 0;
        this.litrosShampooNaMaquina = 0;
    }

    public void colocarPetNaMaquina() {
        if (!maquinaEstaLimpa) {
            System.out.println("A máquina precisa ser limpa antes de colocar um pet!");
            return;
        }

        if (!petEstaNaMaquina) {
            petEstaNaMaquina = true;
            System.out.println("O pet " + nomePet + " foi posto na máquina de banho.");
        } else {
            System.out.println("O pet " + nomePet + " já está na máquina de banho.");
        }
    }

    public void retirarPetDaMaquina() {
        if (!petEstaNaMaquina) {
            System.out.println("O pet " + nomePet + " já está fora da máquina de banho.");
            return;
        }

        petEstaNaMaquina = false;
        if (!petEstaLimpo) {
            maquinaEstaLimpa = false;
            System.out.println("O pet " + nomePet + " foi retirado da máquina de banho, mas ele não está limpo.");
        } else {
            System.out.println("O pet " + nomePet + " foi retirado da máquina de banho.");
        }
    }

    public void verificarSeTemPetNoBanho() {
        if (petEstaNaMaquina) {
            System.out.println("O pet " + nomePet + " está na máquina de banho.");
        } else {
            System.out.println("O pet " + nomePet + " não está na máquina de banho.");
        }
    }

    public void abastecerMaquinaComAgua() {
        if (!verificarCapacidadeAgua()) {
            System.out.println("Você não pode abastecer a máquina com mais de " + MAX_LITROS_AGUA + " litros de água.");
            return;
        }
        litrosAguaNaMaquina += 2;
        System.out.println("Você adicionou 2 litros de água na máquina. Total: " + litrosAguaNaMaquina + " litros.");
    }

    public void abastecerMaquinaComShampoo() {
        if (!verificarCapacidadeShampoo()) {
            System.out.println("Você não pode abastecer a máquina com mais de " + MAX_LITROS_SHAMPOO + " litros de shampoo.");
            return;
        }
        litrosShampooNaMaquina += 2;
        System.out.println("Você adicionou 2 litros de shampoo na máquina. Total: " + litrosShampooNaMaquina + " litros.");
    }

    public void verificarNivelDaAgua() {
        System.out.println("O nível de água da máquina de banho é de " + litrosAguaNaMaquina + " litros.");
        if (litrosAguaNaMaquina < AGUA_NECESSARIA_BANHO) {
            System.out.println("São necessários mais " + (AGUA_NECESSARIA_BANHO - litrosAguaNaMaquina) + " litros para dar banho.");
        }
    }

    public void verificarNivelDeShampoo() {
        System.out.println("O nível de shampoo da máquina de banho é de " + litrosShampooNaMaquina + " litros.");
        if (litrosShampooNaMaquina < SHAMPOO_NECESSARIO_BANHO) {
            System.out.println("São necessários mais " + (SHAMPOO_NECESSARIO_BANHO - litrosShampooNaMaquina) + " litros para dar banho.");
        }
    }

    public void darBanhoNoPet() {
        if (!petEstaNaMaquina) {
            System.out.println("Coloque o pet na máquina primeiro!");
            return;
        }

        if (!verificarRecursosParaBanho()) {
            return;
        }

        litrosAguaNaMaquina -= AGUA_NECESSARIA_BANHO;
        litrosShampooNaMaquina -= SHAMPOO_NECESSARIO_BANHO;
        petEstaLimpo = true;
        maquinaEstaLimpa = false;
        System.out.println("O pet " + nomePet + " tomou banho com sucesso!");
    }

    public void limparMaquina() {
        if (!verificarRecursosParaLimpeza()) {
            return;
        }

        litrosAguaNaMaquina -= AGUA_NECESSARIA_LIMPEZA;
        litrosShampooNaMaquina -= SHAMPOO_NECESSARIO_LIMPEZA;
        maquinaEstaLimpa = true;
        System.out.println("Você limpou a máquina com sucesso.");
    }

    private boolean verificarCapacidadeAgua() {
        return (litrosAguaNaMaquina + 2) <= MAX_LITROS_AGUA;
    }

    private boolean verificarCapacidadeShampoo() {
        return (litrosShampooNaMaquina + 2) <= MAX_LITROS_SHAMPOO;
    }

    private boolean verificarRecursosParaBanho() {
        if (litrosAguaNaMaquina < AGUA_NECESSARIA_BANHO) {
            System.out.println("Faltam " + (AGUA_NECESSARIA_BANHO - litrosAguaNaMaquina) + " litros de água para dar o banho!");
            return false;
        }
        if (litrosShampooNaMaquina < SHAMPOO_NECESSARIO_BANHO) {
            System.out.println("Faltam " + (SHAMPOO_NECESSARIO_BANHO - litrosShampooNaMaquina) + " litros de shampoo para dar o banho!");
            return false;
        }
        return true;
    }

    private boolean verificarRecursosParaLimpeza() {
        if (litrosAguaNaMaquina < AGUA_NECESSARIA_LIMPEZA) {
            System.out.println("Faltam " + (AGUA_NECESSARIA_LIMPEZA - litrosAguaNaMaquina) + " litros de água para limpar a máquina!");
            return false;
        }
        if (litrosShampooNaMaquina < SHAMPOO_NECESSARIO_LIMPEZA) {
            System.out.println("Falta " + (SHAMPOO_NECESSARIO_LIMPEZA - litrosShampooNaMaquina) + " litro de shampoo para limpar a máquina!");
            return false;
        }
        return true;
    }
}