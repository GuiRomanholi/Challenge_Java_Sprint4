package br.com.concertcars.dao;

import br.com.concertcars.models.Carro;
import br.com.concertcars.models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private Connection conexao;

    public void cadastrarCliente(Cliente cliente){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try {
            String sql = "insert into cliente( cpf_clie, nome_clie, email_clie, tel_clie, chassi_gui ) values (?,?,?,?,'ABC1234DEFG56789')";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, cliente.getCpf());
            comandoSql.setString(2, cliente.getNome());
            comandoSql.setString(3, cliente.getEmail());
            comandoSql.setString(4, cliente.getTelefone());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Cliente> buscarTodosClientes(){
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement comandoSql = null;
        conexao = ConnectionFactory.obterConexao();
        try{
            comandoSql = conexao.prepareStatement("Select * from cliente");
            ResultSet rs = comandoSql.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString(1));
                cliente.setNome(rs.getString(2));
                cliente.setEmail(rs.getString(3));
                cliente.setTelefone(rs.getString(4));

                clientes.add(cliente);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente buscarPorId(String cpf) {
        Cliente cliente = new Cliente();
        PreparedStatement comandoSql = null;
        conexao = ConnectionFactory.obterConexao();
        try {
            comandoSql = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf_clie = ?");
            comandoSql.setString(1, cpf);
            ResultSet rs = comandoSql.executeQuery();
            if (rs.next()) {
                cliente.setCpf(rs.getString(1));
                cliente.setNome(rs.getString(2));
                cliente.setTelefone(rs.getString(3));
                cliente.setEmail(rs.getString(4));
            }
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public void deletar(String cpf) {
        Connection conexao = null;
        PreparedStatement comandoSql = null;

        try {
            conexao = ConnectionFactory.obterConexao();
            conexao.setAutoCommit(false);

            String sqlDeletePedidoFormaPagamento = "DELETE FROM pedido_forma_pagamento WHERE num_ped IN (SELECT num_ped FROM pedido WHERE cpf_clie = ?)";
            comandoSql = conexao.prepareStatement(sqlDeletePedidoFormaPagamento);
            comandoSql.setString(1, cpf);
            comandoSql.executeUpdate();

            String sqlDeletePedido = "DELETE FROM pedido WHERE cpf_clie = ?";
            comandoSql = conexao.prepareStatement(sqlDeletePedido);
            comandoSql.setString(1, cpf);
            comandoSql.executeUpdate();

            String sqlDeleteArmazena = "DELETE FROM armazena WHERE placa_car IN (SELECT placa_car FROM carro WHERE cpf_clie = ?)";
            comandoSql = conexao.prepareStatement(sqlDeleteArmazena);
            comandoSql.setString(1, cpf);
            comandoSql.executeUpdate();

            String sqlDeleteCarro = "DELETE FROM carro WHERE cpf_clie = ?";
            comandoSql = conexao.prepareStatement(sqlDeleteCarro);
            comandoSql.setString(1, cpf);
            comandoSql.executeUpdate();

            String sqlDeleteRealiza = "DELETE FROM realiza WHERE cpf_clie = ?";
            comandoSql = conexao.prepareStatement(sqlDeleteRealiza);
            comandoSql.setString(1, cpf);
            comandoSql.executeUpdate();

            String sqlDeleteCliente = "DELETE FROM cliente WHERE cpf_clie = ?";
            comandoSql = conexao.prepareStatement(sqlDeleteCliente);
            comandoSql.setString(1, cpf);
            comandoSql.executeUpdate();

            conexao.commit();
        } catch (SQLException e) {
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            throw new RuntimeException("Erro ao deletar cliente: " + e.getMessage(), e);
        } finally {
            try {
                if (comandoSql != null) {
                    comandoSql.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void alterar(Cliente cliente) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql;
        try {
            String sql = "UPDATE cliente SET nome_clie = ?, tel_clie = ?, email_clie = ?, chassi_gui = 'ABC1234DEFG56789' WHERE cpf_clie = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, cliente.getNome());
            comandoSql.setString(2, cliente.getTelefone());
            comandoSql.setString(3, cliente.getEmail());
            comandoSql.setString(4, cliente.getCpf());

            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
