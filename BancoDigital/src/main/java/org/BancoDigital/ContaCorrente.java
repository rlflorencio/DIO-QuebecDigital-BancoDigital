package org.BancoDigital;

public class ContaCorrente extends Conta{


    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.digito = 7;
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("========");
        System.out.println("Olá " + cliente.getNome() + " este é o extrato da sua Conta Corrente");
        System.out.println("---");
        imprimirInfosComuns();
        System.out.println("---");
    }

    public int getDigito() {
        return digito;
    }

}
