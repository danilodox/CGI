/*
 * Atualiza o painel dos gráficos
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelGrafico extends JPanel{
    
    BufferedImage imageView;
    
    public PanelGrafico(){
        setSize(600, 400);
        setBackground(Color.LIGHT_GRAY);
        imageView = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        //setBackground(Color.GRAY);
        setBorder(BorderFactory.createEtchedBorder());
    }
    
    @Override
    //Desenha as linhas dos eixos no painel principal
    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        //g.drawImage((Image)imageView, 0, 0, null);
        g.drawLine(480, 0, 480, 400); //x
        g.drawLine(0, 300, 600, 300);

    }

    //Atualiza o grafico, limpando a tela
    public void limpaPainel(){
        for(int i=0; i<600; i++){
            for(int j=0; j<400; j++){
                imageView.setRGB(i, j, Color.WHITE.getRGB() );
            }
        }
        repaint();
    }
    
    
}
