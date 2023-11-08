/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.imobiliaria.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Menu Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opções");
        JMenuItem menuItem1 = new JMenuItem("Adicionar Cliente");
        JMenuItem menuItem2 = new JMenuItem("Adicionar Propriedades");

        menuItem1.addActionListener((ActionEvent e) -> {
            new TelaAdicionarCliente().setVisible(true);
        });

        menuItem2.addActionListener((ActionEvent e) -> {
            new TelaAdicionarPropriedade().setVisible(true);
        });

        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
}
