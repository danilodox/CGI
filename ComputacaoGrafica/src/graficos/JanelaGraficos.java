/*
 * Desenha a Janela de Gráficos
 */
package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;  

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
