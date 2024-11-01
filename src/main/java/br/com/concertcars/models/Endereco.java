package br.com.concertcars.models;

public class Endereco {
    private String cep;
    private String cidade;
    private String numero;
    private String estado;

    public String exibirEndereco(){
        return "O guincho vai ir a oficina que está localizada no estado de " + this.estado +
                "\nNa cidade de " + this.cidade + " do cep " + this.cep +
                "com o número " + this.numero;
    }


    //Getters e Setters

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
