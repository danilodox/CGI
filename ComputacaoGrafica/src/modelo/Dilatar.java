/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import processamentoDeImagem.Normalizacao;

/**
 *
 * @author Peu
 */
public class Dilatar {
    private boolean[][] CROSS = {{false, true, false}, {true, true, true}, {false, true, false}};
    private int times;
    private int width;
    private int height;
    private int[][] imagem;
    
    public Dilatar(int[][] imagem, int width, int height, int times){
        this.imagem = imagem;
        this.width = width;
        this.height = height;
        this.times = times;
    }
    
    public Dilatar(){}
    
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

    public int getTimes() {
        return times;
    }
    
    public BufferedImage dilate(BufferedImage img, int times, boolean[][] kernel) {
        BufferedImage out = img;
        for (int i = 0; i < times; i++) {
            out = dilatar(out, kernel);
        }
        return Normalizacao.matrizToBufferedImage(convertToMatriz(out.getRaster()), 255);
    }
    
    public BufferedImage run() {
        BufferedImage out = converterBuffered(imagem);
        for (int i = 0; i < times; i++) {
            out = dilatar(out, CROSS);
        }
        int[][] aux = convertToMatriz(out.getRaster());
        return Normalizacao.matrizToBufferedImage(aux, 255);
    }
    
    /**
     * Opeo de dilao morfogica. Nesta opeo buscamos entre o pixel e seus
     * vizinhos aqueles com o tom de cinza mais claro (de maior valor). Os
     * pixels considerados na busca o aqueles marcados com true no kernel
     * (pixels ativos).
     */
    public BufferedImage dilatar(BufferedImage img, boolean[][] kernel) {
        //Cria a imagem de sda
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        //Percorre a imagem de entrada
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                //A dilao busca pelo pixel de maior valor
                int max = 0;
                //Para cada pixel percorrido na imagem, precisamos percorrer os seus 9 vizinhos
                //Os vizinhos que seo considerados eso marcados como true no kernel
                for (int ky = 0; ky < 3; ky++) {
                    for (int kx = 0; kx < 3; kx++) {
                        //Observe que osndices de kx e ky variam de 0 a 2.  os vizinhos de x seriam
                        //x+(-1), x+0 + x+1. Por isso, subtrmos 1 de kx e ky para chegar no vizinho.
                        int px = x + (kx - 1);
                        int py = y + (ky - 1);

                        //Nas bordas, px ou py podem acabar caindo fora da imagem. Quando isso ocorre, pulamos para o
                        // pximo pixel.
                        if (px < 0 || px >= img.getWidth() || py < 0 || py >= img.getHeight()) {
                            continue;
                        }

                        //Obtem o tom de cinza do pixel
                        int tone = new Color(img.getRGB(px, py)).getRed();

                        //Se ele for mais claro que o maior  encontrado, substitui
                        if (kernel[kx][ky] && tone > max) {
                            max = tone;
                        }
                    }
                }

                //Define essa cor na imagem de sda.
                out.setRGB(x, y, new Color(max, max, max).getRGB());
            }
        }
        return out;
    }
    
    private static int[][] convertToMatriz(Raster matriz) {
        int[][] novaMatriz = new int[matriz.getWidth()][matriz.getHeight()];
        for (int i = 0; i < novaMatriz.length; i++) {
            for (int j = 0; j < novaMatriz.length; j++) {
                novaMatriz[i][j] = matriz.getSample(i, j, 0);
            }
        }
        return novaMatriz;
    }
    
    public static BufferedImage converterBuffered(int[][] mtzImg) {
        // matriz que vc passa como parâmetro definindo a largura da imagem
        int largura = mtzImg.length,
                // matriz que vc passa como parâmetro definindo a altura da imagem
                altura = mtzImg[0].length;

        // criando uma objeto BufferedImage a partir das dimensões da imagem
        // representada pela matriz
        BufferedImage image = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        WritableRaster raster = image.getRaster();
        for (int h = 0; h < largura; h++) {
            for (int w = 0; w < altura; w++) {
                raster.setSample(h, w, 0, mtzImg[h][w]);
            }
        }

        return image;
    }
    
}
