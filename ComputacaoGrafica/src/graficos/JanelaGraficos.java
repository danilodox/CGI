/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;  

/**
 *
 * @author Peu
 */
public class JanelaGraficos extends JFrame{
	private JPanel panel;

	public JanelaGraficos() {
		setTitle("Gráficos");
		panel = new JPanel();
		add(panel);
		setSize(880, 610);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
