/*
 * Painel de menu das transformações das imagens.
 */
package panels;

import enums.TransformacoesImagemEnum;
import javax.swing.JRadioButton;

public class PanelMenuTransf extends javax.swing.JPanel {
    
    private static PanelMenuTransf instance;
    private TransformacoesImagemEnum tipoAlgoritimo;
    private float dados;

    public static synchronized PanelMenuTransf getInstance() {
        if (instance == null) {
            instance = new PanelMenuTransf();
        }
        return instance;
    }
    
    /**
     * Creates new form PanelMenuTransf
     */
    public PanelMenuTransf() {
        initComponents();
        panel_configGamma.setVisible(false);
    }

    public float getDados() {
        return ((Integer) js_gammay.getValue()).floatValue();
    }

    public TransformacoesImagemEnum getTipoAlgoritimo() {
        if (rb_negativo.isSelected()) {
            setTipoAlgoritimo(TransformacoesImagemEnum.NEGATIVO);
        } else if (rb_gamma.isSelected()) {
            setTipoAlgoritimo(TransformacoesImagemEnum.GAMMA);
        } else if (rb_logaritmo.isSelected()) {
            setTipoAlgoritimo(TransformacoesImagemEnum.LOG);
        }
        return tipoAlgoritimo;
    }

    public void setTipoAlgoritimo(TransformacoesImagemEnum tipoAlgoritimo) {
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

        gBtn_filtros = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rb_negativo = new javax.swing.JRadioButton();
        rb_gamma = new javax.swing.JRadioButton();
        rb_logaritmo = new javax.swing.JRadioButton();
        panel_configGamma = new javax.swing.JPanel();
        lab_dados = new javax.swing.JLabel();
        js_gammay = new javax.swing.JSpinner();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        gBtn_filtros.add(rb_negativo);
        rb_negativo.setText("Negativo");
        rb_negativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroSelect(evt);
            }
        });

        gBtn_filtros.add(rb_gamma);
        rb_gamma.setText("Gamma");
        rb_gamma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroSelect(evt);
            }
        });

        gBtn_filtros.add(rb_logaritmo);
        rb_logaritmo.setText("Logaritmo");
        rb_logaritmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroSelect(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_negativo)
                    .addComponent(rb_gamma)
                    .addComponent(rb_logaritmo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_negativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_gamma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_logaritmo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_configGamma.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados para operação"));

        lab_dados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_dados.setText("c = 1 e y = (0 <= y <= 1)");

        javax.swing.GroupLayout panel_configGammaLayout = new javax.swing.GroupLayout(panel_configGamma);
        panel_configGamma.setLayout(panel_configGammaLayout);
        panel_configGammaLayout.setHorizontalGroup(
            panel_configGammaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_configGammaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_configGammaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab_dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_configGammaLayout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addComponent(js_gammay, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addContainerGap())
        );
        panel_configGammaLayout.setVerticalGroup(
            panel_configGammaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_configGammaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab_dados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(js_gammay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_configGamma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_configGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 408, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filtroSelect(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroSelect
        JRadioButton radio = (JRadioButton) evt.getSource();
        PanelTransformacoes.getInstance().setTitle("Transformação " + radio.getText());
        PanelTransformacoes.panel_imagemF.removeAll();
        PanelTransformacoes.panel_imagemF.repaint();
        
        if (rb_negativo.isSelected()) {
            panel_configGamma.setVisible(false);
        } else {
            panel_configGamma.setVisible(true);
            if (rb_gamma.isSelected()) {
                lab_dados.setText("c = 1 e y = (0 <= y <= 1)");
            } else {
                lab_dados.setText("Constante \"a\"");
            }
        }
    }//GEN-LAST:event_filtroSelect


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup gBtn_filtros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner js_gammay;
    private javax.swing.JLabel lab_dados;
    private javax.swing.JPanel panel_configGamma;
    private javax.swing.JRadioButton rb_gamma;
    private javax.swing.JRadioButton rb_logaritmo;
    private javax.swing.JRadioButton rb_negativo;
    // End of variables declaration//GEN-END:variables
}
