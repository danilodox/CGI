package filtros;
import java.awt.image.BufferedImage;
import panels.PanelFiltros;
import processamentoDeImagem.Normalizacao;

/**
 *
 * @author Douglas Rafael
 */
public class FiltroRobertsCruzado {

    PanelFiltros panelFiltros;
    private int[][] imagemMatriz;
    private int imagem[][];
    private int width;
    private int height;

    public FiltroRobertsCruzado(int imagem[][], int width, int height) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
    }

    public FiltroRobertsCruzado() {
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
//                if (((j + 1) < getHeight()) && ((i + 1) < getHeight())) {
//                    aproximacaoY = imagem[i][j] - imagem[i + 1][j + 1];
//                } else {
//                    aproximacaoY = imagem[i][j];
//                }
//
//                if ((i + 1) < getWidth()) {
//                    aproximacaoX += imagem[i + 1][j];
//                }
//                if ((j + 1) < getHeight()) {
//                    aproximacaoX += -imagem[i][j + 1];
//                }
//
//                // Adiciona o novo valor na matriz
//                matrizImagem[i][j] = Math.abs(aproximacaoX) + Math.abs(aproximacaoY);;
//            }
//
//        }
        for (int i = 1; i < getWidth() - 1; i++) {
            for (int j = 1; j < getHeight() - 1; j++) {
                int mask5 = imagem[i][j];
                int mask6 = imagem[i][j + 1];
                int mask8 = imagem[i + 1][j];
                int mask9 = imagem[i + 1][j + 1];
                int gradiente = (mask5 - mask9) + (mask6 - mask8);

                matrizImagem[i][j] = Normalizacao.normalizaPixel(gradiente);
            }
        }

        return Normalizacao.matrizToBufferedImage(matrizImagem);
    }
}
