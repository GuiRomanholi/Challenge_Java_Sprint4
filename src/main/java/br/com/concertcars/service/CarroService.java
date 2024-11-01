package br.com.concertcars.service;

import br.com.concertcars.dao.CarroDao;
import br.com.concertcars.dto.CarroRequestDto;
import br.com.concertcars.models.Carro;

import java.util.List;
import java.util.stream.Collectors;

public class CarroService {

    private CarroDao carroDao = new CarroDao();

    public void cadastrar(CarroRequestDto carroDto){
        Carro carro = carroDto.convert(carroDto);
        carroDao.cadastrarCarro(carro);
    }

    public List<CarroRequestDto> listar(){
        List<Carro> produtos = carroDao.listar();
        return produtos.stream()
                .map(carro -> {
                    CarroRequestDto carroDto = new CarroRequestDto();
                    carroDto.setPlaca(carro.getPlaca());
                    carroDto.setCor(carro.getCor());
                    carroDto.setMarca(carro.getMarca());
                    carroDto.setModelo(carro.getModelo());
                    return carroDto;
                }).collect(Collectors.toList());
    }

    public void deletar(String placa){
        carroDao.deletar(placa);
    }

    public CarroRequestDto buscarPorId(String placa){
        Carro produto = carroDao.buscarPorId(placa);
        CarroRequestDto carroRequestDto = new CarroRequestDto();
        return carroRequestDto.convertToDto(produto);
    }

    public void atualizar(CarroRequestDto produtoDto){
        Carro produto = produtoDto.convert(produtoDto);
        carroDao.alterar(produto);
    }
}
