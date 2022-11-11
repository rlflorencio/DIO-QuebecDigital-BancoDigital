package org.BancoDigital;

public class ContaPoupanca extends Conta{


    public ContaPoupanca(Cliente cliente, Banco banco) {
        super(cliente, banco);
        this.digito = 3;

    }

    @Override
    public void imprimirExtrato(){
        System.out.println("========");
        System.out.println("Olá " + cliente.getNome() + " este é o extrato da sua Conta Poupança");
        System.out.println("---");
        imprimirInfosComuns();
        System.out.println("---");
    }

    public int getDigito() {
        return digito;
    }
}
