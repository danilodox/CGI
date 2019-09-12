/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Peu
 */
public class TJF extends JFrame{
    
    JPanel panel, jPanelMenuLateral;
    JLabel jLabelCoordenadas;
    
    @SuppressWarnings("unchecked")
    private void initGUI() {
        try {
            this.setPreferredSize(new java.awt.Dimension(880, 610));
            this.setBackground(Color.LIGHT_GRAY);
            this.setLayout(null);
                {
                    jPanelMenuLateral = new JPanel();
                    this.add(jPanelMenuLateral);
                    jPanelMenuLateral.setBounds(4, 5, 273, 602);
                    jPanelMenuLateral.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
                    jPanelMenuLateral.setBackground(new java.awt.Color(176,224,230));
                    jPanelMenuLateral.setLayout(null);
                    {
                            jLabelCoordenadas = new JLabel();
                            jPanelMenuLateral.add(jLabelCoordenadas);
                            jLabelCoordenadas.setText("Dados para o Gráfico");
                            jLabelCoordenadas.setBounds(60, 47, 200, 14);
                            jLabelCoordenadas.setFont(new java.awt.Font("Calibri",1,18));
                    }
                }
            } catch (Exception e) {
                    e.printStackTrace();
            }

    }
    
    
    public static void main(String[] args) {
        new TJF().setVisible(true);
    }
}
