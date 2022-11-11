package org.BancoDigital;

public abstract class Conta implements Iconta {

    protected static final int AGENCIA_PADRAO = 1;
    protected static int SEQUENCIAL = 1;

    protected Banco banco;
    protected int agencia;
    protected int numero;
    protected int digito;
    protected float saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente, Banco banco) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.banco = banco;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }
    @Override
    public void depositar(double valor) {
        saldo += valor;
    }
    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns(){
        System.out.println(String.format("Agencia %d", this.agencia));
        System.out.println(String.format("Conta %d", this.numero));
        System.out.println(String.format("Digito %d", this.digito));
        System.out.println(String.format("Saldo %.2f", this.saldo));
    }

    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public int getDigito() {
        return digito;
    }


    @Override
    public String toString() {
        return "{Banco= " + banco +
                ", Agencia=" + agencia +
                ", Numero=" + numero +
                ", Digito=" + digito +
                ", Titular=" + cliente + "}";
    }
}
