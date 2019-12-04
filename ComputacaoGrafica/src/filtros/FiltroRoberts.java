package filtros;

/*
* O filtro de Roberts apresenta a desvantagem de certas bordas serem mais 
* realçadas do que outras dependendo da direção, mesmo com magnitude igual. 
* Como resultado de sua aplicação, obtém-se uma imagem com altos valores 
* de nível de cinza, em regiões de limites bem definidos e valores baixos 
* em regiões de limites suaves, sendo 0 para regiões de nível de cinza 
* constante.
*/

import java.awt.image.BufferedImage;
import panels.PanelFiltros;
import processamentoDeImagem.Normalizacao;

public class FiltroRoberts {

    PanelFiltros panelFiltros;
    private int[][] imagemMatriz;
    private int imagem[][];
    private int width;
    private int height;

    public FiltroRoberts(int imagem[][], int width, int height) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
    }

    public FiltroRoberts() {
    }

    public int[][] getImagemMatriz() {
        return imagemMatriz;
    }

    public void setImagemMatriz(int[][] imagemMatriz) {
        this.imagemMatriz = imagemMatriz;
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
        int matrizImagem[][] = new int[getWidth()][getHeight()];

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                // Aproximações em X e Y
                int aproximacaoX = 0;
                int aproximacaoY = 0;

                if ((j + 1) < getHeight()) {
                    aproximacaoY = imagem[i][j] - imagem[i][j + 1];
                } else {
                    aproximacaoY = imagem[i][j];
                }

                if ((i + 1) < getHeight()) {
                    aproximacaoX = imagem[i][j] - imagem[i + 1][j];
                } else {
                    aproximacaoX = imagem[i][j];
                }

                // Adiciona o novo valor na matriz
                matrizImagem[i][j] = Math.abs(aproximacaoX) + Math.abs(aproximacaoY);
                matrizImagem[i][j] = Normalizacao.normalizaPixel(matrizImagem[i][j]);
            }
        }

        return Normalizacao.matrizToBufferedImage(matrizImagem);
    }
}
