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
public class DilatarBin {
    private int[][] elementoEstruturante;
    private int width, height;
    private int[][] imagem;
    
    public DilatarBin(int[][] imagem, int width, int height){
        elementoEstruturante = new int[3][3];
        elementoEstruturante[0][0] = 1;
        elementoEstruturante[0][1] = 1;
        elementoEstruturante[0][2] = 1;
        elementoEstruturante[1][0] = 1;
        elementoEstruturante[1][1] = 1;
        elementoEstruturante[1][2] = 1;
        elementoEstruturante[2][0] = 1;
        elementoEstruturante[2][1] = 1;
        elementoEstruturante[2][2] = 1;
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
    public BufferedImage dilatarBin() {
        //Cria a imagem de sada
        BufferedImage out = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //matriz auxiliar
        int[][] matrizImagemBinaria = new int[width][height];

        int xPosicao = 0;
        int yPosicao = 0;
        int p0 = 0;
        int p255 = 0;
        int pNovo = 0;
        int pNovo2 = 255;

        // Mdia Padro (limiar 127), Nvel Mdio de Cinza (limiar 94), 10% de Preto (limiar 28),
        // Seleo Iterativa (limiar 82), Otsu (limiar 83), Dois Picos (limiar 109), Borda (limiar 127),
        // Pun (limiar 51), Kapur (limiar 162).
        //percorre toda imagem pixel a pixel para transformar em binaria
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                if (imagem[x][y] >= 127) {
                    imagem[x][y] = 255;
                    p255++;
                } else {
                    imagem[x][y] = 0;
                    p0++;
                }
            }
        }

        if (p0 > p255) {
            pNovo = 255;
            pNovo2 = 0;
        }

        //percorre toda imagem pixel a pixel para realizar dilatacao
        for (int y = 0; y < imagem.length - 1; y++) {
            for (int x = 0; x < imagem[y].length; x++) {
                // so aplica em pixels ativos
                if (imagem[x][y] == pNovo) {
                    // soma a posicao do pixel pelo elemento estruturante
                    for (int xEE = 0; xEE < elementoEstruturante.length; xEE++) {
                        for (int yEE = 0; yEE < elementoEstruturante[xEE].length - 1; yEE++) {
                            // somando a posicao de x, y na imagem com a posicao de x, y do elemento estruturante
                            xPosicao = x + elementoEstruturante[xEE][yEE];
                            yPosicao = y + elementoEstruturante[xEE][yEE + 1];
                            // se essa posicao jah esta com pixel ativo, nao muda nada
                            if (xPosicao >= 0 && yPosicao >= 0 && xPosicao < 256 && yPosicao < 256 && matrizImagemBinaria[xPosicao][yPosicao] != pNovo) {
                                matrizImagemBinaria[xPosicao][yPosicao] = pNovo;

                                //atribui a "out" pixel a pixel o resultado obtido em "matrizImagemBinaria[x][y]"
                                out.setRGB(xPosicao, yPosicao, toColor(matrizImagemBinaria[xPosicao][yPosicao], matrizImagemBinaria[xPosicao][yPosicao], matrizImagemBinaria[xPosicao][yPosicao]));
                            }
                        }

                    }
                    System.out.println(matrizImagemBinaria[x][y]);
                } else {
                    matrizImagemBinaria[x][y] = pNovo2;
                }

            }
        }

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
    
}
