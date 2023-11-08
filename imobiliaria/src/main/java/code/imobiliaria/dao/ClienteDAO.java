/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.imobiliaria.dao;

import code.imobiliaria.modelo.Cliente;
import code.imobiliaria.util.ConexaoDB;
import code.imobiliaria.util.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private final Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, telefone, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.execute();
        } catch (Exception e) {
            Log.error1("An error occurred", (SQLException) e);
        }
    }

    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            Log.error1("An error occurred", (SQLException) e);
        }
        return clientes;
    }

    public void adicionar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, cpf, endereco, telefone) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getEndereco());
            pstmt.setString(4, cliente.getTelefone());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            Log.error1("An error occurred", e);
            // Handle any SQL exceptions
        }
    } 
}


