package Models;

public class ContaBancaria {

    private final String nomeCliente;
    private double saldoConta;
    private final double valorChequeEspecial;
    boolean usandoChequeEspecial = false;
    private double taxaChequeEspecial;


    public ContaBancaria (String nome, double saldo) {

        nomeCliente = nome;

        if (saldo <= 500) valorChequeEspecial = 50;
        else valorChequeEspecial = saldo / 2;
        saldoConta = saldo + valorChequeEspecial;
    }

    public void ConsultarSaldo () {
        System.out.println(nomeCliente + ", saldo da sua conta é: R$" + saldoConta);
    }

    public void ConsultarChequeEspecial () {
        System.out.println("O seu cheque especial tem o valor de R$" + valorChequeEspecial);
    }

    public void DepositarDinheiro (double dinheiro) {
        saldoConta += dinheiro;
        System.out.println("O seu depósito foi feito com sucesso!");
    }

    public void SacarDinheiro (double dinheiro) {
        boolean usandoChequeEspecialSaldo = dinheiro > (saldoConta - valorChequeEspecial);

        if (saldoConta >= dinheiro && usandoChequeEspecialSaldo) {
            System.out.println(nomeCliente + ", você não pode sacar mais do que o seu saldo sem o dinheiro do cheque especial, somente pagar boletos."); return;
        }
        else if (saldoConta >= dinheiro && !usandoChequeEspecialSaldo) {
            saldoConta -= dinheiro;
        }
        else { System.out.println("Seu saldo é insuficiente para este saque;"); return;
         }

        System.out.println("Você sacou R$" + dinheiro + " da sua conta.");
    }

    public void PagarBoleto (double valorBoleto) {
        double saldoContaSemCheque = saldoConta - valorChequeEspecial;
        boolean usandoChequeEspecialBoleto = valorBoleto > saldoContaSemCheque;
        double valorUsadoChequeEspecial = saldoContaSemCheque - valorBoleto;
        taxaChequeEspecial = valorUsadoChequeEspecial * 0.2;

        if (saldoConta >= valorBoleto && usandoChequeEspecialBoleto) {
            saldoConta -= (valorBoleto - taxaChequeEspecial);
            usandoChequeEspecial = true;
            System.out.println("Seu boleto de R$" + valorBoleto + " foi pago com sucesso adicionado à taxa de R$" + taxaChequeEspecial);

        } else if (saldoConta >= valorBoleto && !usandoChequeEspecialBoleto) {
            saldoConta -= valorBoleto;
            System.out.println("Seu boleto de R$" + valorBoleto + " foi pago com sucesso." );
        }
        else System.out.println("Seu saldo é insuficiente para pagar este boleto;");
    }

    public void VerificaUsoChequeEspecial () {
        System.out.println(nomeCliente + ", você " + (usandoChequeEspecial ? "está" : "não está") + " usando o cheque especial");
    }


}
