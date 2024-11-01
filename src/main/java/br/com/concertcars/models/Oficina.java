package br.com.concertcars.models;

public class Oficina {
    private String nome;
    private String cnpj;
    private String razao_social;
    private String contato;

    public String oficinaRecebeuCarro(){
        return "A oficina " + this.nome + " estará com seu veículo" +
                "\nE para caso precise aqui está o contato: " + this.contato;
    }

    //Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
