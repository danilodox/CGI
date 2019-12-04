/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import processamentoDeImagem.Gamma;
import processamentoDeImagem.Logaritmo;
import processamentoDeImagem.Negativo;

/**
 *
 * @author Peu
 */
public class PanelTransformacoes extends javax.swing.JPanel {
    
    private static PanelTransformacoes instance;
    private static BufferedReader imagem;
    private BufferedImage imgT;
    private int[][] imagemMatriz;
    private int imgWidth;
    private int imgHeight;
    private int imgValorMaximo;

    public static synchronized PanelTransformacoes getInstance() {
        if (instance == null) {
            instance = new PanelTransformacoes();
        }
        return instance;
    }

    /**
     * Construtor
     */
    private PanelTransformacoes() {
        initComponents();
    }

    public void setTitle(String text) {
        lab_title.setText(text);
    }

    public int[][] getImagemMatriz() {
        return imagemMatriz;
    }

    public void setImagemMatriz(int[][] imagemMatriz) {
        this.imagemMatriz = imagemMatriz;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lab_title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panel_imagemO = new javax.swing.JPanel();
        panel_imagemF = new javax.swing.JPanel();
        btn_aplyF = new javax.swing.JButton();
        btn_selecImagem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setPreferredSize(new java.awt.Dimension(1047, 669));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lab_title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lab_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_title.setText("Filtro da Média");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lab_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lab_title, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(1047, 669));

        panel_imagemO.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagem original"));
        panel_imagemO.setPreferredSize(new java.awt.Dimension(256, 256));

        javax.swing.GroupLayout panel_imagemOLayout = new javax.swing.GroupLayout(panel_imagemO);
        panel_imagemO.setLayout(panel_imagemOLayout);
        panel_imagemOLayout.setHorizontalGroup(
            panel_imagemOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_imagemOLayout.setVerticalGroup(
            panel_imagemOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );

        panel_imagemF.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagem com filtro"));
        panel_imagemF.setPreferredSize(new java.awt.Dimension(256, 256));

        javax.swing.GroupLayout panel_imagemFLayout = new javax.swing.GroupLayout(panel_imagemF);
        panel_imagemF.setLayout(panel_imagemFLayout);
        panel_imagemFLayout.setHorizontalGroup(
            panel_imagemFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        panel_imagemFLayout.setVerticalGroup(
            panel_imagemFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );

        btn_aplyF.setText("jButton1");
        btn_aplyF.setPreferredSize(new java.awt.Dimension(100, 100));
        btn_aplyF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aplyFActionPerformed(evt);
            }
        });

        btn_selecImagem.setText("Selecionar imagem");
        btn_selecImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecImagemActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Teste"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btn_selecImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(panel_imagemO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(btn_aplyF, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(panel_imagemF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_imagemO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_imagemF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btn_aplyF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_selecImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_selecImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecImagemActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("src/"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PGM Images", "pgm");
            fileChooser.setFileFilter(filter);

            int returnVal = fileChooser.showOpenDialog(btn_selecImagem);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                panel_imagemF.repaint();

                populaImgInPanel(criaImagem(fileChooser.getSelectedFile()), panel_imagemO);
                btn_aplyF.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OPS! Não foi possivel carregar a imagem.");
        }
    }//GEN-LAST:event_btn_selecImagemActionPerformed

    private void btn_aplyFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aplyFActionPerformed
        PanelMenuTransf menuTransformacoes = PanelMenuTransf.getInstance();
        System.out.println("gamma " + menuTransformacoes.getDados());

        switch (menuTransformacoes.getTipoAlgoritimo()) {
            case NEGATIVO:
                panel_imagemF.getGraphics().drawImage(new Negativo(imagemMatriz, getImgWidth(), getImgHeight()).run(), 0, 0, null);
                break;
            case GAMMA:
                panel_imagemF.getGraphics().drawImage(new Gamma(imagemMatriz, getImgWidth(), getImgHeight(), menuTransformacoes.getDados()).run(), 0, 0, null);
                break;
            case LOG:
                panel_imagemF.getGraphics().drawImage(new Logaritmo(imagemMatriz, getImgWidth(), getImgHeight(), menuTransformacoes.getDados()).run(), 0, 0, null);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btn_aplyFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aplyF;
    private javax.swing.JButton btn_selecImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lab_title;
    public static javax.swing.JPanel panel_imagemF;
    private javax.swing.JPanel panel_imagemO;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Ler o arquivo pgm e monta a popula a matriz imagem
     *
     * @param file
     * @return
     */
    public int[][] criaImagem(File file) {
        FileInputStream fileInputStream = null;
        Scanner scan = null;
        try {
            fileInputStream = new FileInputStream(file);
            scan = new Scanner(fileInputStream);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelTransformacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Descarta a primeira linha
        scan.nextLine();

        // Read pic width, height and max value
        imgWidth = scan.nextInt();
        imgHeight = scan.nextInt();
        imgValorMaximo = scan.nextInt();

        /**
         * Monta a matriz imagem com os pixels da imagem selecionada
         */
        imagemMatriz = new int[imgHeight][imgWidth];
        for (int row = 0; row < imgHeight; row++) {
            for (int col = 0; col < imgWidth; col++) {
                // Popula a matriz com os pixels da imagem
                imagemMatriz[row][col] = scan.nextInt();
            }
        }

        try {
            fileInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(PanelTransformacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagemMatriz;
    }
    
    /**
     * Exibe a imagem no jPanel
     *
     * @param img
     * @param imgPanel
     */
    public void populaImgInPanel(int[][] img, JPanel imgPanel) {
        /**
         * Monta a matriz imagem com os pixels da imagem selecionada
         */
        BufferedImage imagemInput = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < img.length; row++) {
            for (int col = 0; col < img[0].length; col++) {
                // Prepara a imagem para ser desenhada no jpanel
                imagemInput.setRGB(col, row, getCorPixel(imagemMatriz[row][col]));
            }
        }
        imgT = imagemInput;

        /**
         * Exibe a imagem no jpanel
         */
        imgPanel.getGraphics().drawImage(imagemInput, 0, 0, null);
    }
    
    /**
     * Retorna o valor em RGB de acordo com o valor do pixel
     *
     * @param corRGB
     * @return
     */
    private int getCorPixel(int corRGB) {
        return new Color(corRGB, corRGB, corRGB).getRGB();
    }
    
}
