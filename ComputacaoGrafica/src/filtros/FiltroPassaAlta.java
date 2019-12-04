package filtros;

/*
 * Passa-Alta: a filtragem passa-alta realça detalhes, produzindo uma 
 * "agudização" ("sharpering") da imagem, isto é, as transições entre 
 * regiões diferentes tornam-se mais nítidas. Estes filtros podem ser 
 * usados para realçar certas características presentes na imagem, tais 
 * como bordas, linhas curvas ou manchas, mas enfatizam o ruído existente 
 * na imagem.
*/

import java.awt.image.BufferedImage;
import panels.PanelFiltros;
import processamentoDeImagem.Normalizacao;

public class FiltroPassaAlta {

    PanelFiltros panelFiltros;
    private int[][] imagemMatriz;
    private int imagem[][];
    private int width;
    private int height;

    public FiltroPassaAlta(int imagem[][], int width, int height) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
    }

    public FiltroPassaAlta() {
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
        
        for (int i = 1; i < getWidth() - 1; i++) {
            for (int j = 1; j < getHeight() - 1; j++) {
                int mask1 = imagem[i - 1][j - 1] * -1;
                int mask2 = imagem[i - 1][j] * -1;
                int mask3 = imagem[i - 1][j + 1] * -1;
                int mask4 = imagem[i][j - 1] * -1;
                int mask5 = imagem[i][j] * 8;
                int mask6 = imagem[i][j + 1] * -1;
                int mask7 = imagem[i + 1][j - 1] * -1;
                int mask8 = imagem[i + 1][j] * -1;
                int mask9 = imagem[i + 1][j + 1] * -1;

                int passaAlta = mask1 + mask2 + mask3 + mask4 + mask5 + mask6 + mask7 + mask8 + mask9;

                matrizImagem[i][j] = Normalizacao.normalizaPixel(passaAlta);
            }
        }

        return Normalizacao.matrizToBufferedImage(matrizImagem);
    }
}
