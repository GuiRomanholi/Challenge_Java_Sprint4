package br.com.concertcars.service;

import br.com.concertcars.dao.ClienteDao;
import br.com.concertcars.dto.CarroRequestDto;
import br.com.concertcars.dto.ClienteRequestDto;
import br.com.concertcars.models.Carro;
import br.com.concertcars.models.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteService {

    private ClienteDao clienteDao = new ClienteDao();

    public void cadastrar(ClienteRequestDto clienteDto){
        Cliente cliente = clienteDto.convert(clienteDto);
        clienteDao.cadastrarCliente(cliente);
    }

    public List<ClienteRequestDto> listar(){
        List<Cliente> produtos = clienteDao.buscarTodosClientes();
        return produtos.stream()
                .map(cliente -> {
                    ClienteRequestDto clienteDto = new ClienteRequestDto();
                    clienteDto.setNome(cliente.getNome());
                    clienteDto.setCpf(cliente.getCpf());
                    clienteDto.setTelefone(cliente.getTelefone());
                    clienteDto.setEmail(cliente.getEmail());
                    return clienteDto;
                }).collect(Collectors.toList());
    }

    public void deletar(String cpf){
        clienteDao.deletar(cpf);
    }

    public ClienteRequestDto buscarPorId(String cpf) {
        Cliente cliente = clienteDao.buscarPorId(cpf);
        ClienteRequestDto clienteRequestDto = new ClienteRequestDto();
        clienteRequestDto.setNome(cliente.getNome());
        clienteRequestDto.setCpf(cliente.getCpf());
        clienteRequestDto.setTelefone(cliente.getTelefone());
        clienteRequestDto.setEmail(cliente.getEmail());
        return clienteRequestDto;
    }

    public void atualizar(ClienteRequestDto produtoDto) {
        Cliente produto = produtoDto.convert(produtoDto);
        clienteDao.alterar(produto);
    }
}
