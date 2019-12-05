/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import processamentoDeImagem.Normalizacao;

/**
 *
 * @author Peu
 */
public class Subtract {
    
    BufferedImage image1;
    BufferedImage image2;
    
    public Subtract(BufferedImage image1, BufferedImage image2){
        this.image1 = image1;
        this.image2 = image2;
    }
    
    public BufferedImage getImg1(){
        return this.image1;
    }
    
    public BufferedImage getImg2(){
        return this.image2;
    }
    
    
    public BufferedImage run() {
        //Cria a imagem de sada
        BufferedImage out = new BufferedImage(image1.getWidth(), image1.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < image1.getHeight(); y++) {
            for (int x = 0; x < image1.getWidth(); x++) {
                //Le o pixel
                Color p1 = new Color(image1.getRGB(x, y));
                Color p2 = new Color(image2.getRGB(x, y));

                //Faz a subtrao, canal a canal
                int tone = p1.getRed() - p2.getRed();

                //Define a cor de sada na imagem de sada (out).
                out.setRGB(x, y, toColor(tone, tone, tone));
            }
        }
        int[][] aux = convertToMatriz(out.getRaster());
        return Normalizacao.matrizToBufferedImage(aux, 255);
    }
    
    /**
     * Converte os valores de r, g e b para o inteiro da cor. Os valores podem
     * estar fora do intervalo de 0 a 255, pois a fo ajusta chamando a fo clamp
     * (acima).
     */
    private int toColor(float r, float g, float b) {
        return new Color(clamp(r), clamp(g), clamp(b)).getRGB();
    }
    
    /**
     * Garante que o valor do pixel esta entre 0 e 255.
     */
    private int clamp(float value) {
        int v = (int) value;
        return v > 255 ? 255 : (v < 0 ? 0 : v);
    }
    
    private static int[][] convertToMatriz(Raster matriz) {
        int[][] novaMatriz = new int[matriz.getWidth()][matriz.getHeight()];
        for (int i = 0; i < novaMatriz.length; i++) {
            for (int j = 0; j < novaMatriz.length; j++) {
                novaMatriz[i][j] = matriz.getSample(i, j, 0);
            }
        }
        return novaMatriz;
    }
}
