package br.com.concertcars.dao;



import br.com.concertcars.models.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDao {

    private Connection conexao;

    public void cadastrarCarro(Carro carro){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try {
            String sql = "insert into carro( placa_car, cor_car, marca_car, modelo_car, cpf_clie, chassi_gui ) values (?,?,?,?,'12345678901','ABC1234DEFG56789')";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, carro.getPlaca());
            comandoSql.setString(2, carro.getCor());
            comandoSql.setString(3, carro.getMarca());
            comandoSql.setString(4, carro.getModelo());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Carro> listar(){
        List<Carro> carros = new ArrayList<>();
        PreparedStatement comandoSql = null;
        conexao = ConnectionFactory.obterConexao();
        try{
            comandoSql = conexao.prepareStatement("Select * from carro");
            ResultSet rs = comandoSql.executeQuery();
            while(rs.next()){
                Carro carro = new Carro();
                carro.setPlaca(rs.getString(1));
                carro.setCor(rs.getString(2));
                carro.setMarca(rs.getString(3));
                carro.setModelo(rs.getString(4));

                carros.add(carro);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return carros;
    }

    public Carro buscarPorId(String placa){
        Carro produto = new Carro();
        PreparedStatement comandoSql = null;
        conexao = ConnectionFactory.obterConexao();
        try{
            comandoSql = conexao.prepareStatement("SELECT * FROM carro WHERE placa_car = ?");
            comandoSql.setString(1, placa);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                produto.setPlaca(rs.getString(1));
                produto.setCor(rs.getString(2));
                produto.setMarca(rs.getString(3));
                produto.setModelo(rs.getString(4));
            }
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produto;
    }

    public void deletar(String placa) {
        Connection conexao = null;
        PreparedStatement comandoSql = null;
        try {
            conexao = ConnectionFactory.obterConexao();

            String sqlPedidoFormaPagamento = "DELETE FROM pedido_forma_pagamento WHERE num_ped IN (SELECT num_ped FROM pedido WHERE cpf_clie IN (SELECT cpf_clie FROM carro WHERE placa_car = ?))";
            comandoSql = conexao.prepareStatement(sqlPedidoFormaPagamento);
            comandoSql.setString(1, placa);
            comandoSql.executeUpdate();

            String sqlPedido = "DELETE FROM pedido WHERE cpf_clie IN (SELECT cpf_clie FROM carro WHERE placa_car = ?)";
            comandoSql = conexao.prepareStatement(sqlPedido);
            comandoSql.setString(1, placa);
            comandoSql.executeUpdate();

            String sqlRealiza = "DELETE FROM realiza WHERE cpf_clie IN (SELECT cpf_clie FROM carro WHERE placa_car = ?)";
            comandoSql = conexao.prepareStatement(sqlRealiza);
            comandoSql.setString(1, placa);
            comandoSql.executeUpdate();

            String sqlDirige = "DELETE FROM dirige WHERE chassi_gui IN (SELECT chassi_gui FROM carro WHERE placa_car = ?)";
            comandoSql = conexao.prepareStatement(sqlDirige);
            comandoSql.setString(1, placa);
            comandoSql.executeUpdate();

            String sqlArmazena = "DELETE FROM armazena WHERE placa_car = ?";
            comandoSql = conexao.prepareStatement(sqlArmazena);
            comandoSql.setString(1, placa);
            comandoSql.executeUpdate();

            String sqlCarro = "DELETE FROM carro WHERE placa_car = ?";
            comandoSql = conexao.prepareStatement(sqlCarro);
            comandoSql.setString(1, placa);
            comandoSql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (comandoSql != null) comandoSql.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void alterar(Carro carro) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql;
        try {
            String sql = "UPDATE carro SET cor_car = ?, marca_car = ?, modelo_car = ?, cpf_clie = '12345678901', chassi_gui = 'ABC1234DEFG56789' WHERE placa_car = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, carro.getCor());
            comandoSql.setString(2, carro.getMarca());
            comandoSql.setString(3, carro.getModelo());
            comandoSql.setString(4, carro.getPlaca());

            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
