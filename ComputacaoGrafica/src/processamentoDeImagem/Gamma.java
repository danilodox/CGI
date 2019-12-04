package processamentoDeImagem;

/*
* Aplica a transformação Gamma na imagem.
*/

import java.awt.image.BufferedImage;

public class Gamma {

    private int[][] imagem;
    private int width;
    private int height;
    private float gamma;

    public Gamma(int[][] imagem, int width, int height, float gamma) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
        this.gamma = gamma;
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

    public float getGamma() {
        return gamma;
    }

    public void setGamma(float gamma) {
        this.gamma = gamma;
    }

    public BufferedImage run() {
        int[][] matrizImagemNegativa = new int[width][height];
        int c = 1;
        // percorre toda imagem pixel a pixel para realizar efeito (negativo)
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {

                // pega o nivel de cor de um pixel
                // retornara o inverso do valor do pixel
                matrizImagemNegativa[x][y] = (int) Math.round(c * Math.pow(imagem[x][y], gamma));
            }
        }

        return Normalizacao.matrizToBufferedImage(matrizImagemNegativa, 255);
    }
}
