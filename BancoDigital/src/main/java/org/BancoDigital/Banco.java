package org.BancoDigital;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
Esta classe representa um banco/This class represents a bank
Como qualquer banco no Brasil, este banco fictício tem CNPJ e código para operações interbancárias.
In Brazil companies have an national registry of legal entities (CNPJ) and an code (código) for interbank transactions.
@author Rafael Florencio
 */
public class Banco {

    private String nome;
    private ArrayList<Conta> contas = new ArrayList<Conta>();
    private String CNPJ;
    private int codigo;
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public Banco() {
        this.nome = "RafaBank";
        this.CNPJ = "28.090.14/0001-90";
        this.codigo = 2809;
    }

    public void imprimirClientes(){
        System.out.println(clientes);
    }

    //Getters & Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Conta> getContas(){
        return contas;
    }
    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }
    public String getCNPJ() {
        return CNPJ;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    public List<Cliente> getClientes() {
        return clientes;
    }

    //Modifica o metodo toString-Modify toString method
    @Override
    public String toString() {
        return nome;
    }
}
