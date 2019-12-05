/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processamentoDeImagem;

import java.awt.image.BufferedImage;

/**
 *
 * @author Peu
 */
public class ITFSigmoide {
    
    private int[][] imagem;
    private int width;
    private int height;
    private int sigma;
    private int w;

    public ITFSigmoide(int[][] imagem, int width, int height, float w, float sigma) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
        this.sigma = (int) sigma;
        this.w = (int) w;
    }

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
    
    public BufferedImage run() {

        // Criar uma imagem de Buffer para receber manipulacoes
        int[][] matrizImagemNegativa = new int[width][height];

        // percorre toda imagem pixel a pixel
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {

                double s = Math.round(255 * (1 / (1 + Math.pow(Math.E, -((imagem[x][y] - w) / sigma)))));
                matrizImagemNegativa[x][y] = (int) s;
            }
        }

        return Normalizacao.matrizToBufferedImage(matrizImagemNegativa, 255);
    }
}
