/*
 * No filtro alto reforço é usado para da enfase a imagem.
 */
package filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;
import processamentoDeImagem.Normalizacao;

public class FiltroAltoReforco {

    private int[][] imagem;

    private int width;
    private int height;
    private double coeficienteW;
    private double coeficienteA;

    public FiltroAltoReforco(int[][] imagem, double coeficienteA, int width, int height) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
        this.coeficienteA = coeficienteA;
        this.coeficienteW = (9 * coeficienteA) - 1;
    }

    public FiltroAltoReforco() {
    }

    public double getCoeficienteW() {
        return coeficienteW;
    }

    public void setCoeficienteW(double coeficienteW) {
        this.coeficienteW = coeficienteW;
    }

    public double getCoeficienteA() {
        return coeficienteA;
    }

    public void setCoeficienteA(double coeficienteA) {
        this.coeficienteA = coeficienteA;
    }

    public int[][] getImagemMatriz() {
        return imagem;
    }

    public void setImagemMatriz(int[][] imagemMatriz) {
        this.imagem = imagemMatriz;
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
    
    public static int getCorPixel(int corRGB) {
        return new Color(corRGB, corRGB, corRGB).getRGB();
    }

    /*
    * A imagem com a passa alta pode ser computada como a diferença
    * entre a imagem original e a imagem filtrada por um filtro 
    * passa baixo.
    */
    
    public BufferedImage run() {
        width = width + 2;
        height = height + 2;
        int[][] matriz_Resultado = new int[height][width];
        int matriz_auxiliar[][] = new int[width][height];
        // inclui em uma imagem auxilar mais uma linha de "zeros" em todas as laterais
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                matriz_auxiliar[i][j] = imagem[i - 1][j - 1];
            }
        }

        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {

                double alto_reforco = -matriz_auxiliar[y - 1][x - 1] - matriz_auxiliar[y - 1][x]
                        - matriz_auxiliar[y - 1][x + 1] - matriz_auxiliar[y][x + 1] + (coeficienteW * matriz_auxiliar[y][x])
                        - matriz_auxiliar[y + 1][x + 1] - matriz_auxiliar[y + 1][x] - matriz_auxiliar[y][x - 1]
                        - matriz_auxiliar[y + 1][x - 1];
                int alto_reforco_aux = (int) Math.round(alto_reforco);
                matriz_Resultado[y - 1][x - 1] = alto_reforco_aux;
            }
        }

        return Normalizacao.matrizToBufferedImage(matriz_Resultado, 255);
    }
}
