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
public class ContornoInternoBin {
    private int[][] elementoEstruturante;
    private int width, height;
    private int[][] imagem;
    
    public ContornoInternoBin(int[][] imagem, int width, int height){
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
    public BufferedImage contornoInternoBin() {
        int p0 = 0;
        int p255 = 0;
        int pNovo = 0;
        int pNovo2 = 255;

        //matriz auxiliar
        int[][] matrizImagemBinaria = new int[width][height];

        // dia Pado (limiar 127), vel dio de Cinza (limiar 94), 10% de Preto (limiar 28),
        // Seo Iterativa (limiar 82), Otsu (limiar 83), Dois Picos (limiar 109), Borda (limiar 127),
        // Pun (limiar 51), Kapur (limiar 162).
        //percorre toda imagem pixel a pixel para transformar em binaria
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                if (imagem[x][y] >= 127) {
                    imagem[x][y] = 255;
                    matrizImagemBinaria[x][y] = 255;
                    p255++;
                } else {
                    imagem[x][y] = 0;
                    matrizImagemBinaria[x][y] = 0;
                    p0++;

                }
            }
        }

        if (p0 > p255) {
            pNovo = 255;
            pNovo2 = 0;
        }

        int[][] parcial = erodirBin(width, height, imagem, elementoEstruturante);

        // retirando os pixels ativos que pertencem a imagem parcial da original
        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem.length; j++) {
                if (imagem[i][j] == pNovo && parcial[i][j] == pNovo) {
                    matrizImagemBinaria[i][j] = pNovo2;
                }
            }
        }

        return Normalizacao.matrizToBufferedImage(parcial, 255);
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
    
    public int[][] erodirBin(int largura, int altura, int[][] matrizImagem, int[][] elementoEstruturante) {
        int[][] matrizImagemBinaria = new int[width][height];

        int xPosicao = 0;
        int yPosicao = 0;
        int p0 = 0;
        int p255 = 0;
        int pNovo = 0;
        int pNovo2 = 255;

        // Mdia Padro (limiar 127), Nvel Mdio de Cinza (limiar 94), 10% de Preto (limiar 28),
        // Seo Iterativa (limiar 82), Otsu (limiar 83), Dois Picos (limiar 109), Borda (limiar 127),
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
                            xPosicao = x - elementoEstruturante[xEE][yEE];
                            yPosicao = y - elementoEstruturante[xEE][yEE + 1];
                            // se essa posicao pixel ativo, se torna inativo
                            if (xPosicao >= 0 && yPosicao >= 0 && xPosicao <= 255 && yPosicao <= 255 && imagem[xPosicao][yPosicao] == pNovo) {
                                matrizImagemBinaria[xPosicao][yPosicao] = pNovo;

                            } else {
                                //desativando pixel
                                matrizImagemBinaria[x][y] = pNovo2;
                            }
                        }

                    }
                    System.out.println(matrizImagemBinaria[x][y]);
                } else {
                    matrizImagemBinaria[x][y] = pNovo2;
                }

            }
        }
        return matrizImagemBinaria;
    }
    
}
