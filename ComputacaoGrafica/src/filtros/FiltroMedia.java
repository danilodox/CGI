package filtros;

/*
 * Filtro de Média. Suavização de Imagens no Domínio Espacial.
 */

import java.awt.image.BufferedImage;
import processamentoDeImagem.Normalizacao;


public class FiltroMedia {

    private int[][] imagem;
    private int width;
    private int height;

    public FiltroMedia(int[][] imagem, int width, int height) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
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
        
        // imagem para realizar
        int[][] matriz_auxiliar = new int[width + 1][height + 1];
        int[][] matrizResultado = new int[width][height];

        // copia a imagem recebida em parametro para a matriz da imagem auxiliar, para
        // poder realizar a operacao
        for (int i = 1; i < matriz_auxiliar.length; i++) {
            for (int j = 1; j < matriz_auxiliar.length; j++) {
                matriz_auxiliar[j][i] = imagem[j - 1][i - 1];
            }
        }

        // realizando efeito midia
        for (int y = 1; y < width; y++) {
            for (int x = 1; x < height; x++) {

                // soma todos os 9 pixel correspondente de onde a mascara estar
                float media = matriz_auxiliar[y - 1][x - 1] + matriz_auxiliar[y - 1][x] + matriz_auxiliar[y - 1][x + 1]
                        + matriz_auxiliar[y][x + 1] + matriz_auxiliar[y][x] + matriz_auxiliar[y + 1][x + 1]
                        + matriz_auxiliar[y + 1][x] + matriz_auxiliar[y][x - 1] + matriz_auxiliar[y + 1][x - 1];

                // pega o resultado da soma e faz a midia dividindo por 9
                media = media / 9;

                // coloca resultado na imagem de saida
                matrizResultado[y - 1][x - 1] = Math.round(media);
            }
        }/*
        int CoeficienteDeNormalizacao = 0;
        int matrizImagem[][] = new int[width][height];

        // Soma os valores dos pixels da matriz para determinar o coeficiente de normalização
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                CoeficienteDeNormalizacao = CoeficienteDeNormalizacao + imagem[i][j];
            }
        }
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {

                //soma dos pixeis da vizinhan�a
                int soma = 0;

                soma += imagem[i][j];
                if ((i - 1) >= 0) {
                    soma += imagem[i - 1][j] / CoeficienteDeNormalizacao;
                }
                if ((i + 1) < getWidth()) {
                    soma += imagem[i + 1][j] / CoeficienteDeNormalizacao;
                }
                if ((j - 1) >= 0) {
                    soma += imagem[i][j - 1] / CoeficienteDeNormalizacao;
                }
                if ((j + 1) < getHeight()) {
                    soma += imagem[i][j + 1] / CoeficienteDeNormalizacao;
                }
                if (((i - 1) >= 0) && ((j - 1) >= 0)) {
                    soma += imagem[i - 1][j - 1] / CoeficienteDeNormalizacao;
                }
                if (((i + 1) < getWidth()) && ((j - 1) >= 0)) {
                    soma += imagem[i + 1][j - 1] / CoeficienteDeNormalizacao;
                }
                if (((i - 1) >= 0) && ((j + 1) < getHeight())) {
                    soma += imagem[i - 1][j + 1] / CoeficienteDeNormalizacao;
                }
                if (((i + 1) < getWidth()) && ((j + 1) < getHeight())) {
                    soma += imagem[i + 1][j + 1] / CoeficienteDeNormalizacao;
                }

                //adiciona a soma dos valores RGB da vizinhançaa na posiçao central
                matrizImagem[i][j] = Math.round(soma);
            }
        }*/
        
        return Normalizacao.normalizaImage(matrizResultado);
    }
}
