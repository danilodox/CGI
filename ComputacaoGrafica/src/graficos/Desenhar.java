/*
 * 
 */
package graficos;

import java.awt.image.BufferedImage;

public class Desenhar {
    
    public int xInic, yInic = 300;
    
    public void drawPixel(int x, int y, BufferedImage bi){
        try {
            bi.setRGB(x+xInic, y+yInic, 20);
        } catch(Exception e){
            
        }
    }
    
}
