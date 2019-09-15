/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import view.JanelaPrincipal;
import auxiliar.Ponto;
import enums.CircEnum;
import enums.RasterEnum;
import javax.swing.JTextArea;

/**
 *
 * @author Peu
 */
public class PanelMenuCircunferencia extends javax.swing.JPanel {
    
    public static PanelMenuCircunferencia instance;
    private float raioX, raioY;
    
    private CircEnum tipoAlgoritimo;
    
    private Ponto p1, p2;
    
    /**
     * Creates new form PanelMenuRaster
     */
    public PanelMenuCircunferencia() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rb_pm = new javax.swing.JRadioButton();
        rb_ee = new javax.swing.JRadioButton();
        rb_trig = new javax.swing.JRadioButton();
        rb_elip = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        raiox = new javax.swing.JSpinner();
        raioy = new javax.swing.JSpinner();
        btn_desenhar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Algoritmo de Rasterização"));

        buttonGroup1.add(rb_pm);
        rb_pm.setText("Ponto Médio");
        rb_pm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_pmActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_ee);
        rb_ee.setText("Equação Explícita");
        rb_ee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_eeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_trig);
        rb_trig.setText("Trigonométrica");
        rb_trig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_trigActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_elip);
        rb_elip.setText("Elipse");
        rb_elip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_elipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_pm)
                    .addComponent(rb_ee)
                    .addComponent(rb_trig)
                    .addComponent(rb_elip))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_pm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_ee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_trig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rb_elip)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Circunferencia"));

        jLabel1.setText("Raio");

        raiox.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 1.0f));

        raioy.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 1.0f));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(raiox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(raioy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(raiox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raioy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_desenhar.setText("Desenhar");
        btn_desenhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desenharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_desenhar, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_desenhar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(411, 411, 411))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_desenharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desenharActionPerformed
        setRaioX((float) raiox.getValue());
        
        if (rb_pm.isSelected()) {
            setTipoAlgoritimo(CircEnum.PONTO_MEDIO);
        } else if (rb_ee.isSelected()) {
            setTipoAlgoritimo(CircEnum.EQUACAO_EXPLICITA);
        } else if (rb_trig.isSelected()) {
            setTipoAlgoritimo(CircEnum.TRIGONOMETRIA);
        }/* else if (rb_elip.isSelected()) {
            setRaioY((float) raioy.getValue());
            setTipoAlgoritimo(CircEnum.ELIPSE);
        }*/
        
        JanelaPrincipal.runResult(this);
    }//GEN-LAST:event_btn_desenharActionPerformed

    private void rb_pmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_pmActionPerformed
        raioy.setVisible(false);
    }//GEN-LAST:event_rb_pmActionPerformed

    private void rb_eeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_eeActionPerformed
        raioy.setVisible(false);
    }//GEN-LAST:event_rb_eeActionPerformed

    private void rb_trigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_trigActionPerformed
        raioy.setVisible(false);
    }//GEN-LAST:event_rb_trigActionPerformed

    private void rb_elipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_elipActionPerformed
        raioy.setVisible(true);
    }//GEN-LAST:event_rb_elipActionPerformed
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_desenhar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner raiox;
    private javax.swing.JSpinner raioy;
    private javax.swing.JRadioButton rb_ee;
    private javax.swing.JRadioButton rb_elip;
    private javax.swing.JRadioButton rb_pm;
    private javax.swing.JRadioButton rb_trig;
    // End of variables declaration//GEN-END:variables
    
    public static synchronized PanelMenuCircunferencia getInstance() {
        if (instance == null) {
            instance = new PanelMenuCircunferencia();
        }
        return instance;
    }
    
    public void setRaioX(float raiox){
        this.raioX = raiox;
    }
    
    public float getRaioX(){
        return raioX;
    }
    
    public void setRaioY(float raioy){
        this.raioY = raioy;
    }
    
    public float getRaioY(){
        return raioY;
    }
    
    public CircEnum getTipoAlgoritimo() {
        return tipoAlgoritimo;
    }

    public void setTipoAlgoritimo(CircEnum tipoAlgoritimo) {
        this.tipoAlgoritimo = tipoAlgoritimo;
    }
    
}
