package filtros;

import java.awt.image.BufferedImage;
import panels.PanelFiltros;
import processamentoDeImagem.Normalizacao;

/**
 *
 * @author Douglas Rafael
 */
public class FiltroPrewitt {

    PanelFiltros panelFiltros;
    private int[][] imagemMatriz;
    private int imagem[][];
    private int width;
    private int height;

    public FiltroPrewitt(int imagem[][], int width, int height) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
    }

    public FiltroPrewitt() {
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

//        for (int i = 0; i < getHeight(); i++) {
//            for (int j = 0; j < getWidth(); j++) {
//                // Aproximações em X e Y
//                int aproximacaoX = 0;
//                int aproximacaoY = 0;
//
//                if (((i - 1) >= 0) && ((j + 1) < getHeight())) {
//                    aproximacaoX += imagem[i - 1][j + 1];
//                    aproximacaoY -= imagem[i - 1][j + 1];
//                }
//
//                if ((j + 1) < getHeight()) {
//                    aproximacaoX += imagem[i][j + 1];
//                }
//
//                if (((i + 1) < getWidth()) && ((j + 1) < getHeight())) {
//                    aproximacaoX += imagem[i + 1][j + 1];
//                    aproximacaoY += imagem[i + 1][j + 1];
//                }
//
//                if (((i - 1) >= 0) && ((j - 1) >= 0)) {
//                    aproximacaoX -= imagem[i - 1][j - 1];
//                    aproximacaoY -= imagem[i - 1][j - 1];
//                }
//
//                if ((j - 1) >= 0) {
//                    aproximacaoX -= imagem[i][j - 1];
//                }
//
//                if (((i + 1) < getWidth()) && ((j - 1) >= 0)) {
//                    aproximacaoX -= imagem[i + 1][j - 1];
//                    aproximacaoY += imagem[i + 1][j - 1];
//                }
//
//                if ((i + 1) < getWidth()) {
//                    aproximacaoY += imagem[i + 1][j];
//                }
//
//                if ((i - 1) >= 0) {
//                    aproximacaoY -= imagem[i - 1][j];
//                }
//
//                // Adiciona o novo valor na matriz
//                matrizImagem[i][j] = Math.abs(aproximacaoX) + Math.abs(aproximacaoY);;
//            }
        for (int i = 1; i < getWidth() - 1; i++) {
            for (int j = 1; j < getHeight() - 1; j++) {
                int mask1 = imagem[i - 1][j - 1];
                int mask2 = imagem[i - 1][j];
                int mask3 = imagem[i - 1][j + 1];
                int mask4 = imagem[i][j - 1];
                int mask6 = imagem[i][j + 1];
                int mask7 = imagem[i + 1][j - 1];
                int mask8 = imagem[i + 1][j];
                int mask9 = imagem[i + 1][j + 1];
                int prewitt = Math.abs((mask7 + mask8 + mask9) - (mask1 + mask2 + mask3))
                        + Math.abs((mask3 + mask6 + mask9) - (mask1 + mask4 + mask7));

                matrizImagem[i][j] = Normalizacao.normalizaPixel(prewitt);
            }
        }
        return Normalizacao.matrizToBufferedImage(matrizImagem);
    }
}
