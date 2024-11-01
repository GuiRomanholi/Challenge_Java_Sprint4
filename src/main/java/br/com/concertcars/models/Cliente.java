package br.com.concertcars.models;

import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public void cadastrarCliente() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual o seu nome: ");
        nome = leitor.nextLine();
        System.out.println("Qual o seu cpf: ");
        cpf = leitor.nextLine();
        System.out.println("Qual o seu telefone: ");
        telefone = leitor.nextLine();
        System.out.println("Qual o seu email: ");
        email = leitor.nextLine();
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, CPF: %s, Telefone: %s, Email: %s", nome, cpf, telefone, email);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
