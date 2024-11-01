package br.com.concertcars.dto;

import br.com.concertcars.models.Carro;

public class CarroRequestDto {
    private String cor;
    private String placa;
    private String marca;
    private String modelo;


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public CarroRequestDto convertToDto(Carro carro){
        CarroRequestDto carroRequestDto = new CarroRequestDto();
        carroRequestDto.setCor(carro.getCor());
        carroRequestDto.setPlaca(carro.getPlaca());
        carroRequestDto.setMarca(carro.getMarca());
        carroRequestDto.setModelo(carro.getModelo());
        return carroRequestDto;
    }

    public Carro convert(CarroRequestDto carroRequestDto){
        Carro carro = new Carro();
        carro.setCor(carroRequestDto.getCor());
        carro.setPlaca(carroRequestDto.getPlaca());
        carro.setMarca(carroRequestDto.getMarca());
        carro.setModelo(carroRequestDto.getModelo());
        return carro;
    }

    //Getters e Setters


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
