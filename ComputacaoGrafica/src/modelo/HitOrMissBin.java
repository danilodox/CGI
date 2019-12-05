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
public class HitOrMissBin {
    private int[][] elementoEstruturante;
    private int width, height;
    private int[][] imagem;
    
    public HitOrMissBin(int[][] imagem, int width, int height){
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
    public BufferedImage hitOrMissBin() {
        int p0 = 0;
        int p255 = 0;
        int pNovo = 0;
        int pNovo2 = 255;

        //matrizes auxiliares
        int[][] matrizImagemBinaria = new int[width][height];
        int[][] matrizAux = new int[width][height];

        int[][] parcial = erodirBin(width, height, imagem, elementoEstruturante);

        //elemento estruturante que engloba o inicial
        int[][] newElementoEstruturante = new int[11][2];
        newElementoEstruturante[0][0] = -1;
        newElementoEstruturante[0][1] = -2;
        newElementoEstruturante[1][0] = -1;
        newElementoEstruturante[1][1] = -1;
        newElementoEstruturante[2][0] = -1;
        newElementoEstruturante[2][1] = 0;
        newElementoEstruturante[3][0] = -1;
        newElementoEstruturante[3][1] = 1;
        newElementoEstruturante[4][0] = -1;
        newElementoEstruturante[4][1] = 2;
        newElementoEstruturante[5][0] = 0;
        newElementoEstruturante[5][1] = 2;
        newElementoEstruturante[6][0] = 1;
        newElementoEstruturante[6][1] = -2;
        newElementoEstruturante[7][0] = 1;
        newElementoEstruturante[7][1] = -1;
        newElementoEstruturante[8][0] = 1;
        newElementoEstruturante[8][1] = 0;
        newElementoEstruturante[9][0] = 1;
        newElementoEstruturante[9][1] = 1;
        newElementoEstruturante[10][0] = 1;
        newElementoEstruturante[10][1] = 2;

        // dia Pado (limiar 127), vel dio de Cinza (limiar 94), 10% de Preto (limiar 28),
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

        // fazer a imagem complemento da original binaria
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                if (imagem[x][y] == pNovo) {
                    matrizAux[x][y] = pNovo2;
                    p255++;
                } else {
                    matrizAux[x][y] = pNovo;
                    p0++;
                }
            }
        }

        int[][] parcial2 = erodirBin(width, height, matrizAux, newElementoEstruturante);

        for (int i = 0; i < parcial2.length; i++) {
            for (int j = 0; j < parcial2.length; j++) {
                if (parcial[i][j] == pNovo && parcial2[i][j] == pNovo) {
                    matrizImagemBinaria[i][j] = pNovo;
                } else {
                    matrizImagemBinaria[i][j] = pNovo2;
                }
            }
        }

        return Normalizacao.matrizToBufferedImage(matrizImagemBinaria, 255);
    }
    
    public int[][] erodirBin(int largura, int altura, int[][] matrizImagem, int[][] elementoEstruturante) {
        //matriz auxiliar
        int[][] matrizImagemBinaria = new int[largura][altura];

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
        for (int y = 0; y < largura; y++) {
            for (int x = 0; x < altura; x++) {
                if (matrizImagem[x][y] >= 127) {
                    matrizImagem[x][y] = 255;
                    p255++;
                } else {
                    matrizImagem[x][y] = 0;
                    p0++;
                }
            }
        }

        if (p0 > p255) {
            pNovo = 255;
            pNovo2 = 0;
        }

        //percorre toda imagem pixel a pixel para realizar dilatacao
        for (int y = 0; y < matrizImagem.length - 1; y++) {
            for (int x = 0; x < matrizImagem[y].length; x++) {
                // so aplica em pixels ativos
                if (matrizImagem[x][y] == pNovo) {
                    // soma a posicao do pixel pelo elemento estruturante
                    for (int xEE = 0; xEE < elementoEstruturante.length; xEE++) {
                        for (int yEE = 0; yEE < elementoEstruturante[xEE].length - 1; yEE++) {
                            // somando a posicao de x, y na imagem com a posicao de x, y do elemento estruturante
                            xPosicao = x - elementoEstruturante[xEE][yEE];
                            yPosicao = y - elementoEstruturante[xEE][yEE + 1];
                            // se essa posicao pixel ativo, se torna inativo
                            if (xPosicao >= 0 && yPosicao >= 0 && xPosicao <= 255 && yPosicao <= 255 && matrizImagem[xPosicao][yPosicao] == pNovo) {
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
