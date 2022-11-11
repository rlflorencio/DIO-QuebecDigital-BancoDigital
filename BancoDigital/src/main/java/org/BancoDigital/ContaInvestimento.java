package org.BancoDigital;

public class ContaInvestimento extends Conta{
    public ContaInvestimento(Cliente cliente, Banco banco) {
        super(cliente, banco);
        this.digito = 15;
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("========");
        System.out.println("Olá " + cliente.getNome() + " este é o extrato da sua Conta Investimento");
        System.out.println("---");
        imprimirInfosComuns();
        System.out.println("---");
    }

    public int getDigito() {
        return digito;
    }
}
