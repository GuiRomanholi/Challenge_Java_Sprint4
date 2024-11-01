package br.com.concertcars.dto;

import br.com.concertcars.models.Carro;
import br.com.concertcars.models.Cliente;

public class ClienteRequestDto {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public ClienteRequestDto convertToDto(Cliente cliente){
        ClienteRequestDto clienteRequestDto = new ClienteRequestDto();
        clienteRequestDto.setNome(cliente.getNome());
        clienteRequestDto.setCpf(cliente.getCpf());
        clienteRequestDto.setTelefone(getTelefone());
        clienteRequestDto.setEmail(getEmail());
        return clienteRequestDto;
    }

    public Cliente convert(ClienteRequestDto clienteRequestDto) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequestDto.getNome());
        cliente.setCpf(clienteRequestDto.getCpf());
        cliente.setTelefone(clienteRequestDto.getTelefone());
        cliente.setEmail(clienteRequestDto.getEmail());
        return cliente;
    }

    //Getters e Setters
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
