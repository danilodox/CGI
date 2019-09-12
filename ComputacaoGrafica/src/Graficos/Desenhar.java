/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.image.BufferedImage;

/**
 *
 * @author Peu
 */
public class Desenhar {
    
    public int xInic, yInic = 300;
    
    public void drawPixel(int x, int y, BufferedImage bi){
        try {
            bi.setRGB(x+xInic, y+yInic, 20);
        } catch(Exception e){
            
        }
    }
    
}
