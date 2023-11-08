/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.imobiliaria.gui;


import code.imobiliaria.dao.ClienteDAO;
import code.imobiliaria.modelo.Cliente;
import  code.imobiliaria.util.ConexaoDB;
import code.imobiliaria.util.Log;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class TelaAdicionarCliente extends JFrame {

    private final JTextField txtNome;
    private final JTextField txtEmail;
    private final JTextField txtTelefone;

    public TelaAdicionarCliente() {
        setTitle("Adicionar Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField();

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();

        JLabel lblTelefone = new JLabel("Telefone:");
        txtTelefone = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            salvarCliente();
        });

        add(lblNome);
        add(txtNome);
        add(lblEmail);
        add(txtEmail);
        add(lblTelefone);
        add(txtTelefone);
        add(new JLabel()); // Espaço vazio
        add(btnSalvar);
    }

    private void salvarCliente() {
    Cliente cliente = new Cliente();
    cliente.setNome(txtNome.getText());
    cliente.setEmail(txtEmail.getText());
    cliente.setTelefone(txtTelefone.getText());
    
    // Get a connection from ConexaoDB
    try (Connection connection = ConexaoDB.getConnection()) {
        ClienteDAO clienteDAO = new ClienteDAO(connection);
        clienteDAO.adicionar(cliente);

        JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
        limparCampos();
    } catch (SQLException e) {
        e.printStackTrace();
        Log.error3("An error occurred", e);
        // Handle any SQL exceptions
    }
}

    private void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
    }
}

