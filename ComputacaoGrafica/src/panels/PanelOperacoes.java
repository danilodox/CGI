/*
 * Painel das operações entre as imagens.
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
import operacoes.OperacaoAND;
import operacoes.OperacaoAdicao;
import operacoes.OperacaoDivisao;
import operacoes.OperacaoMultiplicacao;
import operacoes.OperacaoOR;
import operacoes.OperacaoSubstracao;
import operacoes.OperacaoXOR;

public class PanelOperacoes extends javax.swing.JPanel {
    
    private static PanelOperacoes instance;
    private static BufferedReader imagem;
    private BufferedImage imgT;
    private int[][] imagemMatriz;
    private int[][] imagemMatriz1;
    private int[][] imagemMatriz2;
    private int imgWidth;
    private int imgHeight;
    private int imgValorMaximo;

    public static synchronized PanelOperacoes getInstance() {
        if (instance == null) {
            instance = new PanelOperacoes();
        }
        return instance;
    }

    /**
     * Construtor
     */
    private PanelOperacoes() {
        initComponents();
    }

    public void setTitle(String text) {
        lab_title.setText(text);
    }

    public int[][] getImagemMatriz() {
        return imagemMatriz1;
    }

    public void setImagemMatriz(int[][] imagemMatriz) {
        this.imagemMatriz1 = imagemMatriz;
    }

    public int[][] getImagemMatriz2() {
        return imagemMatriz2;
    }

    public void setImagemMatriz2(int[][] imagemMatriz2) {
        this.imagemMatriz2 = imagemMatriz2;
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
        panel_imagem1 = new javax.swing.JPanel();
        panel_imagem2 = new javax.swing.JPanel();
        btn_aplyOpr = new javax.swing.JButton();
        btn_selecImagem1 = new javax.swing.JButton();
        panel_resultado = new javax.swing.JPanel();
        btn_selecImagem2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1047, 669));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lab_title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lab_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_title.setText("Operação de adição");

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

        panel_imagem1.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagem original"));
        panel_imagem1.setPreferredSize(new java.awt.Dimension(256, 256));

        javax.swing.GroupLayout panel_imagem1Layout = new javax.swing.GroupLayout(panel_imagem1);
        panel_imagem1.setLayout(panel_imagem1Layout);
        panel_imagem1Layout.setHorizontalGroup(
            panel_imagem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_imagem1Layout.setVerticalGroup(
            panel_imagem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );

        panel_imagem2.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagem com filtro"));
        panel_imagem2.setPreferredSize(new java.awt.Dimension(256, 256));

        javax.swing.GroupLayout panel_imagem2Layout = new javax.swing.GroupLayout(panel_imagem2);
        panel_imagem2.setLayout(panel_imagem2Layout);
        panel_imagem2Layout.setHorizontalGroup(
            panel_imagem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        panel_imagem2Layout.setVerticalGroup(
            panel_imagem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );

        btn_aplyOpr.setText("Aplicar");
        btn_aplyOpr.setPreferredSize(new java.awt.Dimension(100, 100));
        btn_aplyOpr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aplyOprActionPerformed(evt);
            }
        });

        btn_selecImagem1.setText("Selecionar imagem");
        btn_selecImagem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecImagem1ActionPerformed(evt);
            }
        });

        panel_resultado.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado da operação"));

        javax.swing.GroupLayout panel_resultadoLayout = new javax.swing.GroupLayout(panel_resultado);
        panel_resultado.setLayout(panel_resultadoLayout);
        panel_resultadoLayout.setHorizontalGroup(
            panel_resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        panel_resultadoLayout.setVerticalGroup(
            panel_resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        btn_selecImagem2.setText("Selecionar imagem");
        btn_selecImagem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecImagem2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_selecImagem1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(panel_imagem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_aplyOpr, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(panel_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_imagem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_selecImagem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_imagem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_imagem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_selecImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_selecImagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btn_aplyOpr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(panel_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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

    private void btn_selecImagem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecImagem1ActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("src/"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PGM Images", "pgm");
            fileChooser.setFileFilter(filter);

            int returnVal = fileChooser.showOpenDialog(btn_selecImagem1);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                imagemMatriz1 = criaImagem(fileChooser.getSelectedFile());

                populaImgInPanel(imagemMatriz1, panel_imagem1);
                panel_resultado.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OPS! Não foi possivel carregar a imagem.");
        }
    }//GEN-LAST:event_btn_selecImagem1ActionPerformed

    private void btn_aplyOprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aplyOprActionPerformed
        PanelMenuOperacoes menuOperacoes = PanelMenuOperacoes.getInstance();
        try {
            switch (menuOperacoes.getTipoAlgoritimo()) {
                case ADICAO:
                    panel_resultado.getGraphics().drawImage(new OperacaoAdicao(imagemMatriz1, imagemMatriz2, getImgWidth(), getImgHeight()).run(), 0, 0, null);
                    break;
                case SUBSTRACAO:
                    panel_resultado.getGraphics().drawImage(new OperacaoSubstracao(imagemMatriz1, imagemMatriz2, getImgWidth(), getImgHeight()).run(), 0, 0, null);
                    break;
                case MULTIPLICACAO:
                    panel_resultado.getGraphics().drawImage(new OperacaoMultiplicacao(imagemMatriz1, imagemMatriz2, getImgWidth(), getImgHeight()).run(), 0, 0, null);
                    break;
                case DIVISAO:
                    panel_resultado.getGraphics().drawImage(new OperacaoDivisao(imagemMatriz1, imagemMatriz2, getImgWidth(), getImgHeight()).run(), 0, 0, null);
                    break;
                case OR:
                    panel_resultado.getGraphics().drawImage(new OperacaoOR(imagemMatriz1, imagemMatriz2, getImgWidth(), getImgHeight()).run(), 0, 0, null);
                    break;
                case AND:
                    panel_resultado.getGraphics().drawImage(new OperacaoAND(imagemMatriz1, imagemMatriz2, getImgWidth(), getImgHeight()).run(), 0, 0, null);
                    break;
                case XOR:
                    panel_resultado.getGraphics().drawImage(new OperacaoXOR(imagemMatriz1, imagemMatriz2, getImgWidth(), getImgHeight()).run(), 0, 0, null);
                    break;
            }
        } catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Selecione uma operação");
        }
    }//GEN-LAST:event_btn_aplyOprActionPerformed

    private void btn_selecImagem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecImagem2ActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("src/"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PGM Images", "pgm");
            fileChooser.setFileFilter(filter);

            int returnVal = fileChooser.showOpenDialog(btn_selecImagem2);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                imagemMatriz2 = criaImagem(fileChooser.getSelectedFile());

                populaImgInPanel(imagemMatriz2, panel_imagem2);
                btn_aplyOpr.setEnabled(true);
                panel_resultado.repaint();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OPS! Não foi possivel carregar a imagem.");
        }
    }//GEN-LAST:event_btn_selecImagem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aplyOpr;
    private javax.swing.JButton btn_selecImagem1;
    private javax.swing.JButton btn_selecImagem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lab_title;
    private javax.swing.JPanel panel_imagem1;
    private javax.swing.JPanel panel_imagem2;
    public static javax.swing.JPanel panel_resultado;
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
            Logger.getLogger(PanelOperacoes.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PanelOperacoes.class.getName()).log(Level.SEVERE, null, ex);
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
