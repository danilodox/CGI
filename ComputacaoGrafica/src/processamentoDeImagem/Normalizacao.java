/*
 * Classe que realiza a operação de normalização da imagem.
 */
package processamentoDeImagem;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Normalizacao {
    private Normalizacao() {
    }

    /**
     * Normaliza uma imagem
     *
     * @param matriz
     * @return
     */
    public static BufferedImage normalizaImage(int[][] matriz) {
        int[][] matrizImg = normalizaMatrizImage(matriz);
        BufferedImage imagem = new BufferedImage(matriz[0].length, matriz.length, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < matrizImg.length; i++) {
            for (int j = 0; j < matrizImg[0].length; j++) {
                // Equação para normalizar pixels
                imagem.setRGB(j, i, getCorPixel(matrizImg[i][j]));
            }
        }

        return imagem;
    }

    //Esse método usa o truncamento para normalizar a imagem.
    public static int normalizaPixel(int pixel) {
        if (pixel > 255) {
            return 255;
        } else if (pixel < 0) {
            return 0;
        }
        return pixel;
    }

    /**
     * Normaliza os pixels contindo na matriz que representa uma imagem
     *
     * @param matriz
     * @return
     */
    public static int[][] normalizaMatrizImage(int[][] matriz) {
        int matrizNomalizada[][] = new int[matriz[0].length][matriz.length];

        int fMax = getMax(matriz);
        int fMin = getMin(matriz);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                // Equação para normalizar pixels
                matrizNomalizada[i][j] = Math.round(255 * (matriz[i][j] - fMin) / (fMax - fMin));
            }
        }

        return matrizNomalizada;
    }

    public static int getCorPixel(int corRGB) {
        return new Color(corRGB, corRGB, corRGB).getRGB();
    }

    public static BufferedImage matrizToBufferedImage(int[][] matrizImg, int w) {
        int altura = matrizImg.length;
        int largura = matrizImg.length;
        int[][] matrizPontosImagem = new int[10][9];
        BufferedImage resultado = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        int[][] matriz_normalizada = new int[altura][largura];
        double maior_pixel = 0;
        double menor_pixel = 65025; // 255 * 255 = 65025

        for (int i = 0; i < matrizImg.length; i++) {
            for (int j = 0; j < matrizImg.length; j++) {

                int valor_pixel = matrizImg[i][j];
                if (valor_pixel > maior_pixel) {
                    maior_pixel = valor_pixel;
                }

                if (valor_pixel < menor_pixel) {
                    menor_pixel = valor_pixel;
                }
            }
        }
        for (int i = 0; i < matriz_normalizada.length; i++) {
            for (int j = 0; j < matriz_normalizada.length; j++) {

                double fun1 = (w / (maior_pixel - menor_pixel));
                double fun2 = (matrizImg[i][j] - menor_pixel);
                double fun3 = Math.round(fun1 * fun2);
                matriz_normalizada[i][j] = (int) (fun3);

                // Matriz para apresentar na Tela - Pixels
                if (i < 10 && j < 9) {
                    matrizPontosImagem[i][j] = (int) (fun3);
                }
                resultado.setRGB(j, i, getCorPixel(matriz_normalizada[i][j]));
            }
        }

        return resultado;
    }

    /**
     * Retorna o maior inteiro da matriz
     *
     * @param matriz
     * @return O maior valor
     */
    public static int getMax(int[][] matriz) {
        return getValue(matriz, false);
    }

    /**
     * Retorna o menor inteiro da matriz
     *
     * @param matriz
     * @return O menor valor
     */
    public static int getMin(int[][] matriz) {
        return getValue(matriz, true);
    }

    /**
     * Retorna o maior ou menor inteiro da matriz
     *
     * @param matriz
     * @param isMin
     * @return O maior valor
     */
    private static int getValue(int[][] matriz, boolean isMin) {
        int value = matriz[0][0];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (isMin) {
                    if (matriz[i][j] < value) {
                        value = matriz[i][j];
                    }
                } else if (matriz[i][j] > value) {
                    value = matriz[i][j];
                }
            }
        }

        return value;
    }
}
