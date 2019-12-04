package operacoes;

/*
* Operação de multiplicação entre duas imagens.
*/

import java.awt.image.BufferedImage;
import processamentoDeImagem.Normalizacao;

public class OperacaoMultiplicacao {

    private final int[][] imagem1;
    private final int[][] imagem2;
    private final int width;
    private final int height;

    public OperacaoMultiplicacao(int[][] imagem1, int[][] imagem2, int width, int height) {
        this.imagem1 = imagem1;
        this.imagem2 = imagem2;
        this.width = width;
        this.height = height;
    }

    //Aplica a operação de Multiplicação entre as imagens
    public BufferedImage run() {
        int matrizImagemMult[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                matrizImagemMult[i][j] = imagem1[i][j] * imagem2[i][j];
            }
        }

        return Normalizacao.normalizaImage(matrizImagemMult);
    }
}
