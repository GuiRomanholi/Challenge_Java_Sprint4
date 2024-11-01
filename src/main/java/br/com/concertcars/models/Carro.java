package br.com.concertcars.models;

public class Carro {
    protected String cor;
    private String placa;
    protected String marca;
    protected String modelo;


    @Override
    public String toString() {
        return String.format("Cor: %s, Placa: %s, Marca: %s, Modelo: %s", cor, placa, marca, modelo);
    }

    //Getters e Setters


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
