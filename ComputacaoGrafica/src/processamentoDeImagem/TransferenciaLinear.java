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
public class TransferenciaLinear {
    private int[][] imagem;
    private int width;
    private int height;
    private int brilho;
    private int contraste;

    public TransferenciaLinear(int[][] imagem, int width, int height, float contraste, float brilho) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
        this.contraste = (int) contraste;
        this.brilho = (int) brilho;
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

        // percorre toda imagem pixel a pixel para realizar efeito (negativo)
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {

                // pega o nivel de cor de um pixel
                // retornar o inverso do valor do pixel
                matrizImagemNegativa[y][x] = imagem[y][x] * contraste + brilho;
            }
        }

        return Normalizacao.matrizToBufferedImage(matrizImagemNegativa, 255);
    }
}
