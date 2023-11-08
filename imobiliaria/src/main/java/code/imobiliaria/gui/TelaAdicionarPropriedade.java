/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.imobiliaria.gui;

import code.imobiliaria.dao.PropriedadeDAO;
import code.imobiliaria.modelo.Propriedade;
import code.imobiliaria.util.ConexaoDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaAdicionarPropriedade extends JFrame {

    private final JTextField txtNome;
    private final JTextField txtEndereco;
    private final JTextField txtPreco;

    public TelaAdicionarPropriedade() {
        setTitle("Adicionar Propriedade");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField();

        JLabel lblEndereco = new JLabel("Endereço:");
        txtEndereco = new JTextField();

        JLabel lblPreco = new JLabel("Preço:");
        txtPreco = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener((ActionEvent e) -> {
            try {
                salvarPropriedade();
            } catch (SQLException ex) {
                Logger.getLogger(TelaAdicionarPropriedade.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        add(lblNome);
        add(txtNome);
        add(lblEndereco);
        add(txtEndereco);
        add(lblPreco);
        add(txtPreco);
        add(new JLabel()); // Espaço vazio
        add(btnSalvar);
    }

    private void salvarPropriedade() throws SQLException {
        Propriedade propriedade = new Propriedade();
        propriedade.setNome(txtNome.getText());
        propriedade.setEndereco(txtEndereco.getText());
        propriedade.setPreco(Double.parseDouble(txtPreco.getText()));

    // Get a connection from ConexaoDB
    try (Connection connection = ConexaoDB.getConnection()) {
        PropriedadeDAO propriedadeDAO = new PropriedadeDAO(connection);
        propriedadeDAO.adicionar(propriedade);

        JOptionPane.showMessageDialog(this, "Propriedade salva com sucesso!");
        limparCampos();
    }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtEndereco.setText("");
        txtPreco.setText("");
    }
}
