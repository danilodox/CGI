/*
 * Painel do menu de recorte da reta no viewport.
 */
package panels;

import auxiliar.Ponto;
import enums.RasterEnum;
import formas.Rasterizacao;
import formas.RecorteException;
import formas.RecorteLinha;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import operacoes.PlanoCartesiano;

public class PanelMenuRecorteReta extends javax.swing.JPanel {
    
    private static PanelMenuRecorteReta instance;

    private Ponto pontoInicial, pontoFinal;
    private Color color;
    private RasterEnum tipoAlgoritimo;
    private List<Ponto> listaPontos;
    
    /**
     * Creates new form PanelMenuRecorteReta
     */
    public PanelMenuRecorteReta() {
        initComponents();
    }
    
    public static synchronized PanelMenuRecorteReta getInstance() {
        if (instance == null) {
            instance = new PanelMenuRecorteReta();
        }
        return instance;
    }

    public Ponto getPontoInicial() {
        return pontoInicial;
    }

    public void setPontoInicial(Ponto pontoInicial) {
        this.pontoInicial = pontoInicial;
    }

    public Ponto getPontoFinal() {
        return pontoFinal;
    }

    public void setPontoFinal(Ponto pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

    public RasterEnum getTipoAlgoritimo() {
        return tipoAlgoritimo;
    }

    public void setTipoAlgoritimo(RasterEnum tipoAlgoritimo) {
        this.tipoAlgoritimo = tipoAlgoritimo;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        xMin = new javax.swing.JSpinner();
        yMin = new javax.swing.JSpinner();
        xMax = new javax.swing.JSpinner();
        yMax = new javax.swing.JSpinner();
        btn_desenharVP = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        js_xInicial = new javax.swing.JSpinner();
        js_xFinal = new javax.swing.JSpinner();
        js_yInicial = new javax.swing.JSpinner();
        js_yFinal = new javax.swing.JSpinner();
        btn_applyR = new javax.swing.JButton();
        btn_desenharReta = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Criar janela de visão"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Xmax:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ymax:");

        jLabel3.setText("Xmin:");

        jLabel4.setText("Ymin:");

        xMin.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        yMin.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        xMax.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        yMax.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(yMin, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(xMin))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(yMax, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(xMax))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(xMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(yMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_desenharVP.setText("Desenhar viewport");
        btn_desenharVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desenharVPActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pontos"));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Y");

        jLabel7.setText("Inicial:");

        jLabel8.setText("Final");

        js_xInicial.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        js_xFinal.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        js_yInicial.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        js_yFinal.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(js_xFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(js_xInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(js_yFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(js_yInicial, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(js_xInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(js_yInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(js_xFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(js_yFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_applyR.setText("Aplicar recorte");
        btn_applyR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_applyRActionPerformed(evt);
            }
        });

        btn_desenharReta.setText("Desenhar reta");
        btn_desenharReta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desenharRetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_desenharVP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_applyR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_desenharReta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_desenharVP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_desenharReta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_applyR, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 204, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_desenharVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desenharVPActionPerformed
        listaPontos = new ArrayList<>();

        listaPontos.add(new Ponto((double) xMin.getValue(), (double) yMin.getValue()));
        listaPontos.add(new Ponto((double) xMax.getValue(), (double) yMin.getValue()));
        listaPontos.add(new Ponto((double) xMax.getValue(), (double) yMax.getValue()));
        listaPontos.add(new Ponto((double) xMin.getValue(), (double) yMax.getValue()));

        PlanoCartesiano.getInstance().desenhaViewPort(listaPontos);
    }//GEN-LAST:event_btn_desenharVPActionPerformed

    private void btn_desenharRetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desenharRetaActionPerformed
        PlanoCartesiano.getInstance().desenhaViewPort(listaPontos);
        // Seta as coordenadas dos pontos e seta no obejto Ponto
        setPontoInicial(new Ponto((double) js_xInicial.getValue(), (double) js_yInicial.getValue()));
        setPontoFinal(new Ponto((double) js_xFinal.getValue(), (double) js_yFinal.getValue()));

//        PanelPlanoCartesiano.getInstance().getGraphics().drawLine((int) pontoInicial.getX(), (int) pontoInicial.getY(), (int) pontoFinal.getX(), (int) pontoFinal.getY());
        Rasterizacao.getInstance().bresenham(this.getPontoInicial(), this.getPontoFinal(), null);
    }//GEN-LAST:event_btn_desenharRetaActionPerformed

    private void btn_applyRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_applyRActionPerformed
        PlanoCartesiano.getInstance().redesenha();
        listaPontos = new ArrayList<>();
        List<Ponto> listaPontoReta;

        listaPontos.add(new Ponto((double) js_xInicial.getValue(), (double) js_yInicial.getValue()));
        listaPontos.add(new Ponto((double) js_xFinal.getValue(), (double) js_yFinal.getValue()));

        try {
            if (RecorteLinha.getInstance().isRetaInJanela((double) xMin.getValue(), (double) xMax.getValue(), (double) yMin.getValue(), (double) yMax.getValue(), listaPontos.get(0), listaPontos.get(1))) {
                listaPontoReta = RecorteLinha.getInstance().recorteFinal((double) xMin.getValue(), (double) xMax.getValue(), (double) yMin.getValue(), (double) yMax.getValue(), listaPontos);
                btCriarJanela(evt);
                Rasterizacao.getInstance().bresenham(listaPontoReta.get(0), listaPontoReta.get(1), null);
//                PanelPlanoCartesiano.getInstance().getGraphics().drawLine((int)listaPontoReta.get(0).getX() , (int)listaPontoReta.get(0).getY(), (int) (int)listaPontoReta.get(1).getX(), (int) (int)listaPontoReta.get(1).getY());
            }

// Seta a cor selecionada no jPanel 
        } catch (RecorteException ex) {
            JOptionPane.showMessageDialog(this.getRootPane(), ex.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_applyRActionPerformed
    
    private void btCriarJanela(java.awt.event.ActionEvent evt) {                               
        listaPontos = new ArrayList<>();

        listaPontos.add(new Ponto((double) xMin.getValue(), (double) yMin.getValue()));
        listaPontos.add(new Ponto((double) xMax.getValue(), (double) yMin.getValue()));
        listaPontos.add(new Ponto((double) xMax.getValue(), (double) yMax.getValue()));
        listaPontos.add(new Ponto((double) xMin.getValue(), (double) yMax.getValue()));

        PlanoCartesiano.getInstance().desenhaViewPort(listaPontos);

    }       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_applyR;
    private javax.swing.JButton btn_desenharReta;
    private javax.swing.JButton btn_desenharVP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner js_xFinal;
    private javax.swing.JSpinner js_xInicial;
    private javax.swing.JSpinner js_yFinal;
    private javax.swing.JSpinner js_yInicial;
    private javax.swing.JSpinner xMax;
    private javax.swing.JSpinner xMin;
    private javax.swing.JSpinner yMax;
    private javax.swing.JSpinner yMin;
    // End of variables declaration//GEN-END:variables
}
