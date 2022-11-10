package org.BancoDigital;

public class Cliente {
    private static int SEQUENCIAL_ID = 1;
    private String nome;
    private String sobrenome;
    private int id;

    public Cliente(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.id = SEQUENCIAL_ID++;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getId() {
        return id;
    }
}
