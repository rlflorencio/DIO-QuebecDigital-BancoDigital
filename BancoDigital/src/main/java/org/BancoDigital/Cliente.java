package org.BancoDigital;

public class Cliente {
    private static int SEQUENCIAL_ID = 1;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private int id;

    public Cliente(String nome, String sobrenome, String telefone, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.id = SEQUENCIAL_ID++;
    }

    //Getters and Setters
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public int getId() {
        return id;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getNome() + " " + getSobrenome();
    }
}
