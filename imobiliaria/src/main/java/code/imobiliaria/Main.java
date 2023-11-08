/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package code.imobiliaria;
import code.imobiliaria.gui.TelaPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author victor.gabriel
 */

public class Main {
    public static void main(String[] args) {
        // Criando uma instância da tela principal
        TelaPrincipal tela = new TelaPrincipal();
        
        // Configurando propriedades básicas da janela
        tela.setTitle("Sistema Imobiliária");
        tela.setSize(800, 600);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null); // Centraliza a janela
        
        // Exibindo a janela
        tela.setVisible(true);
    }
}