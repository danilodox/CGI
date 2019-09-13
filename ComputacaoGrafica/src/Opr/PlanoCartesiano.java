/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Opr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Peu
 */
public class PlanoCartesiano extends JPanel{
    
    public static PlanoCartesiano instance;
    
    private PlanoCartesiano() {
        /**
         * Evento click do mouse. Denha um ponto no plano cartesiano.
         */
        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                Graphics g = event.getComponent().getGraphics();
                g.setColor(Color.RED);
                g.fillOval(event.getX() - 3, event.getY() - 3, 6, 6);
            }
        });

        /**
         * Evento arrastar do mouse. Desenha a mão livre no plano cartesiano.
         */
        super.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = e.getComponent().getGraphics();
                g.setColor(Color.RED);
                g.fillOval(e.getX() - 2, e.getY() - 2, 4, 4);
            }
        });
    }
    
    public static synchronized PlanoCartesiano getInstance() {
        if (instance == null) {
            instance = new PlanoCartesiano();
        }

        return instance;
    }
    
    public int getLargura() {
        return super.getWidth();
    }

    /**
     * Retorna a altura do plano cartesiano.
     *
     * @return
     */
    public int getAltura() {
        return super.getHeight();
    }

    /**
     * width/2
     *
     * @return
     */
    public int getValorCentroX() {
        return getLargura() / 2;
    }

    /**
     * height/2
     *
     * @return
     */
    public int getValorCentroY() {
        return getAltura() / 2;
    }

    /**
     * Desenha o plano
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.white);
        g.setColor(Color.LIGHT_GRAY);
        
        // Reta x
        g.drawLine(0, getValorCentroY(), getLargura(), getValorCentroY()); // x1, y1, x2, y2 
        
        // Reta y
        g.drawLine(getValorCentroX(), 0, getValorCentroX(), getAltura()); // x1, y1, x2, y2 
    }
    
    public void redesenha() {
        if (instance != null) {
            instance.getGraphics().clearRect(0, 0, this.getLargura(), this.getAltura());
            this.paint(this.getGraphics()); // Desenha o plano cartesiano novamente
        }
    }

    /**
     * Desenha o pixel no plano cartesiano de acordo com os parametros. OBS. Os
     * pontos não são normalizados.
     *
     * @param x - Coordenada x
     * @param y - Coordenada y
     * @param color - Cor do pixel
     */
    public void drawPixel(int x, int y, Color color) {
        // Pega instância do graphics para desenhar no plano cartesiano
        Graphics g = super.getGraphics();
        g.setColor(color);
        g.fillRect(x, y, 1, 1);

//        bufferedImage = new BufferedImage(getLargura(),getAltura(),BufferedImage.TYPE_INT_RGB);
//        Graphics g = bufferedImage.getGraphics();
//        bufferedImage.setRGB(x, y, Color.LIGHT_GRAY.getRGB());
//        g.drawImage(bufferedImage, 0, 0, null);
    }

    /**
     * Desenha o pixel no plano cartesiano de acordo com os parametros. OBS. Os
     * pontos são normalizados!
     *
     * @param x - Coordenada x
     * @param y - Coordenada y
     * @param color - Cor do pixel
     */
    public void drawPixel(double x, double y, Color color) {
        // Normalizando os pontos
        x = (x + PlanoCartesiano.getInstance().getValorCentroX());
        y = (PlanoCartesiano.getInstance().getValorCentroY() - y);

        drawPixel(Math.round((float) x), Math.round((float) y), color);
    }

    /**
     * Desenha objeto 2D no plano cartesiano.
     *
     * @param color
     * @param matrizObjeto
     */
    public void drawObjeto2D(double[][] matrizObjeto, Color color) {
        redesenha();

        // Pega instância do graphics para desenhar no plano cartesiano
        Graphics g = this.getGraphics();
        g.setColor(color);

        g.drawLine(this.getValorCentroX() + (int) matrizObjeto[0][0], this.getValorCentroY() - (int) matrizObjeto[1][0], this.getValorCentroX() + (int) matrizObjeto[0][1], this.getValorCentroY() - (int) matrizObjeto[1][1]);
        g.drawLine(this.getValorCentroX() + (int) matrizObjeto[0][1], this.getValorCentroY() - (int) matrizObjeto[1][1], this.getValorCentroX() + (int) matrizObjeto[0][2], this.getValorCentroY() - (int) matrizObjeto[1][2]);
        g.drawLine(this.getValorCentroX() + (int) matrizObjeto[0][2], this.getValorCentroY() - (int) matrizObjeto[1][2], this.getValorCentroX() + (int) matrizObjeto[0][3], this.getValorCentroY() - (int) matrizObjeto[1][3]);
        g.drawLine(this.getValorCentroX() + (int) matrizObjeto[0][3], this.getValorCentroY() - (int) matrizObjeto[1][3], this.getValorCentroX() + (int) matrizObjeto[0][0], this.getValorCentroY() - (int) matrizObjeto[1][0]);
    }

    /**
     * Retorna o valor em RGB de acordo com o valor do pixel
     *
     * @param corRGB
     * @return
     */
    public int getCorPixel(int corRGB) {
        return new Color(corRGB, corRGB, corRGB).getRGB();
    }
    
}
