/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.imobiliaria.dao;

import code.imobiliaria.modelo.Propriedade;
import code.imobiliaria.util.ConexaoDB;
import code.imobiliaria.util.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropriedadeDAO {

    private final Connection conexao;

    public PropriedadeDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Propriedade> listarTodas() {
        List<Propriedade> propriedades = new ArrayList<>();
        String sql = "SELECT * FROM propriedades";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Propriedade propriedade = new Propriedade();
                propriedade.setId(rs.getInt("id"));
                propriedade.setNome(rs.getString("nome"));
                propriedade.setEndereco(rs.getString("endereco"));
                propriedade.setPreco(rs.getDouble("preco"));
                propriedade.setTipo(rs.getString("tipo"));
                propriedade.setDescricao(rs.getString("descricao"));
                propriedade.setDataCadastro(rs.getDate("data_cadastro"));
                propriedades.add(propriedade);
            }
        } catch (Exception e) {
            Log.error2("An error occurred", (SQLException) e);
        }
        return propriedades;
    }

    public void inserir(Propriedade propriedade) {
        String sql = "INSERT INTO propriedades (nome, endereco, preco, tipo, descricao, data_cadastro) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, propriedade.getNome());
            stmt.setString(2, propriedade.getEndereco());
            stmt.setDouble(3, propriedade.getPreco());
            stmt.setString(4, propriedade.getTipo());
            stmt.setString(5, propriedade.getDescricao());
            stmt.setDate(6, new java.sql.Date(propriedade.getDataCadastro().getTime()));
            stmt.executeUpdate();
        } catch (Exception e) {
            Log.error2("An error occurred", (SQLException) e);
        }
    }

    public void atualizar(Propriedade propriedade) {
        String sql = "UPDATE propriedades SET nome=?, endereco=?, preco=?, tipo=?, descricao=? WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, propriedade.getNome());
            stmt.setString(2, propriedade.getEndereco());
            stmt.setDouble(3, propriedade.getPreco());
            stmt.setString(4, propriedade.getTipo());
            stmt.setString(5, propriedade.getDescricao());
            stmt.setInt(6, propriedade.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM propriedades WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            Log.error2("An error occurred", (SQLException) e);
        }
    }

    public Propriedade buscarPorId(int id) {
        Propriedade propriedade = null;
        String sql = "SELECT * FROM propriedades WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                propriedade = new Propriedade();
                propriedade.setId(rs.getInt("id"));
                propriedade.setNome(rs.getString("nome"));
                propriedade.setEndereco(rs.getString("endereco"));
                propriedade.setPreco(rs.getDouble("preco"));
                propriedade.setTipo(rs.getString("tipo"));
                propriedade.setDescricao(rs.getString("descricao"));
                propriedade.setDataCadastro(rs.getDate("data_cadastro"));
            }
        } catch (Exception e) {
            Log.error2("An error occurred", (SQLException) e);
        }
        return propriedade;
    }

    public void adicionar(Propriedade propriedade) {
        String sql = "INSERT INTO propriedades (endereco, descricao, tipo, preco, regiao, proprietario_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, propriedade.getEndereco());
            pstmt.setString(2, propriedade.getDescricao());
            pstmt.setString(3, propriedade.getTipo());
            pstmt.setDouble(4, propriedade.getPreco());
            pstmt.setString(5, propriedade.getRegiao());
            pstmt.setInt(6, propriedade.getProprietarioId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            Log.error2("An error occurred", e);
            // Handle any SQL exceptions
        }
    }

    
}
