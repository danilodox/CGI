/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import processamentoDeImagem.Normalizacao;

/**
 *
 * @author Peu
 */
public class AberturaBin {
    private int[][] elementoEstruturante;
    private int width, height;
    private int[][] imagem;
    
    public AberturaBin(int[][] imagem, int width, int height){
        elementoEstruturante = new int[3][2];
        elementoEstruturante[0][0] = 0;
        elementoEstruturante[0][1] = -1;
        elementoEstruturante[1][0] = 0;
        elementoEstruturante[1][1] = 0;
        elementoEstruturante[2][0] = 0;
        elementoEstruturante[2][1] = 1;
        this.width = width;
        this.height = height;
        this.imagem = imagem;
    }
    
    public int[][] getImagem() {
        return imagem;
    }

    public void setImagem(int[][] imagem) {
        this.imagem = imagem;
    }
    
    public int[][] getElementoEstruturante() {
        return elementoEstruturante;
    }

    public void setElementoEstruturante(int[][] elementoEstruturante) {
        this.elementoEstruturante = elementoEstruturante;
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
    
    /**
     * Operao de dilatao morfolgica binaria.
     */
    public BufferedImage aberturaBin() {
        // dia Pado (limiar 127), vel dio de Cinza (limiar 94), 10% de Preto (limiar 28),
        // Seo Iterativa (limiar 82), Otsu (limiar 83), Dois Picos (limiar 109), Borda (limiar 127),
        // Pun (limiar 51), Kapur (limiar 162).
        //percorre toda imagem pixel a pixel para transformar em binaria
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                if (imagem[x][y] >= 127) {
                    imagem[x][y] = 255;
                } else {
                    imagem[x][y] = 0;
                }
            }
        }

        int[][] parcial = convertToMatriz((new DilatarBin(imagem, width, height).dilatarBin()).getRaster());
        int[][] matrizImagemBinaria = convertToMatriz((new ErosaoBin(parcial, width, height).erodirBin()).getRaster());

        return Normalizacao.matrizToBufferedImage(matrizImagemBinaria, 255);
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
