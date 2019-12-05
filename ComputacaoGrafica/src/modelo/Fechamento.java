/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import processamentoDeImagem.Normalizacao;

/**
 *
 * @author Peu
 */
public class Fechamento {
    private boolean[][] CROSS = {{false, true, false}, {true, true, true}, {false, true, false}};
    private int times;
    private int width;
    private int height;
    private int[][] imagem;
    
    public Fechamento(int[][] imagem, int width, int height, int times){
        this.imagem = imagem;
        this.width = width;
        this.height = height;
        this.times = times;
    }
    
    public Fechamento(){}
    
    public int[][] getImagem() {
        return imagem;
    }

    public void setImagem(int[][] imagem) {
        this.imagem = imagem;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTimes() {
        return times;
    }
    
    public BufferedImage fechamento(BufferedImage img, int times, boolean[][] kernel) {
        BufferedImage c = new Erosao().erode(new Dilatar().dilate(img, times, kernel), times, kernel);
        int[][] aux = convertToMatriz(c.getRaster());
        return Normalizacao.matrizToBufferedImage(aux, 255);
    }
    
    public BufferedImage run(){
        int[][] img1 = convertToMatriz((new Dilatar(imagem, width, height, times).run()).getRaster());
        BufferedImage out = new Erosao(img1, width, height, times).run();
        
        int[][] aux = convertToMatriz(out.getRaster());
        return Normalizacao.matrizToBufferedImage(aux, 255);
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
