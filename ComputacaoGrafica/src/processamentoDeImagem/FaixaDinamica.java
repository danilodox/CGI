/*
 * Classe da tranformação de faixa dinamica da imagem
 */
package processamentoDeImagem;

import java.awt.image.BufferedImage;

public class FaixaDinamica {
    private int[][] imagem;
    private int width;
    private int height;
    private int w;

    public FaixaDinamica(int[][] imagem, int width, int height, float w) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
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
    
    //Aplica a transformação
    public BufferedImage run() {

        int[][] matrizImagemNegativa = new int[width][height];
        int fmin = fMin(imagem, width, height);
        int fmax = fMax(imagem, width, height);
        int dif = 256 - w;

        // percorre toda imagem pixel a pixel para realizar a transformacao
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {

                // pega o nivel de cor de um pixel
                matrizImagemNegativa[y][x] = ((imagem[y][x] - fmin) / (fmax - fmin)) * w;
            }
        }

        return Normalizacao.matrizToBufferedImage(matrizImagemNegativa, 255);
    }
    
    //Funções auxiliares que retornam o valor de fMax e fMin
    private int fMax(int[][] matrizImagem, int largura, int altura) {
        int max = matrizImagem[0][0];

        for (int y = 0; y < largura; y++) {
            for (int x = 0; x < altura; x++) {
                if (max < matrizImagem[y][x]) {
                    max = matrizImagem[y][x];
                }
            }
        }

        return max;
    }

    private int fMin(int[][] matrizImagem, int largura, int altura) {
        int min = matrizImagem[0][0];

        for (int y = 0; y < largura; y++) {
            for (int x = 0; x < altura; x++) {
                if (min > matrizImagem[y][x]) {
                    min = matrizImagem[y][x];
                }
            }
        }

        return min;
    }
}
