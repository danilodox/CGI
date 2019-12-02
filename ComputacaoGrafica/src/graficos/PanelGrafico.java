/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Peu
 */
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
    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponents(g);

        //g.drawImage((Image)imageView, 0, 0, null);
        g.drawLine(480, 0, 480, 400); //x
        g.drawLine(0, 300, 600, 300);

    }

    public void limpaPainel(){
        for(int i=0; i<600; i++){
            for(int j=0; j<400; j++){
                imageView.setRGB(i, j, Color.WHITE.getRGB() );
            }
        }
        repaint();
    }
    
    
}
