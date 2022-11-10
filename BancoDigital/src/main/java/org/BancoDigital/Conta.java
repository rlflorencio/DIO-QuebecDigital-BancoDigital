package org.BancoDigital;

public abstract class Conta implements Iconta {

    protected static final int AGENCIA_PADRAO = 1;
    protected static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected int digito;
    protected float saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
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

}
