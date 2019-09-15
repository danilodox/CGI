/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Graficos.PanelGrafico;
import Operacoes.NormalizationsFunctions;
import Operacoes.PlanoCartesiano;
import Retas.Circunferencia;
import Retas.Rasterizacao;
import static enums.CircEnum.ELIPSE;
import static enums.CircEnum.EQUACAO_EXPLICITA;
import static enums.CircEnum.TRIGONOMETRIA;
import enums.RasterEnum;
import static enums.RasterEnum.PONTO_MEDIO;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import panels.PanelMenuCircunferencia;
import panels.PanelMenuRaster;



/**
 *
 * @author Peu
 */
public class JanelaPrincipal extends javax.swing.JFrame {
    
    //private final PanelGrafico pg;
    private final PanelMenuRaster panelMenuRaster;
    private final PanelMenuCircunferencia panelMenuCirc;
    /**
     * Creates new form JanelaGrafica
     */
    public JanelaPrincipal() {
        panelMenuRaster = PanelMenuRaster.getInstance();
        panelMenuCirc = PanelMenuCircunferencia.getInstance();
        initComponents();
        //openMenuReta(null);
        coordinatesSystem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBox = new javax.swing.JPanel();
        panelFooter = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lab_DCX = new javax.swing.JLabel();
        lab_DCY = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lab_NDCX = new javax.swing.JLabel();
        lab_NDCY = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lab_X = new javax.swing.JLabel();
        lab_Y = new javax.swing.JLabel();
        panelGrafic = Operacoes.PlanoCartesiano.getInstance();
        lab_cTela = new javax.swing.JLabel();
        panMenu = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuDesenhar = new javax.swing.JMenu();
        jm_reta = new javax.swing.JMenuItem();
        jm_circ = new javax.swing.JMenuItem();
        menuTransformacoes = new javax.swing.JMenu();
        subMenu2d = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelBox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelBoxMouseMoved(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Coordenadas de entrada"));

        lab_DCX.setText("DCX:");

        lab_DCY.setText("DCY:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab_DCX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lab_DCY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab_DCX)
                .addGap(18, 18, 18)
                .addComponent(lab_DCY)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Coordenadas normalizadas"));

        jLabel1.setText("NDCX:");

        jLabel2.setText("NDCY:");

        lab_NDCX.setText("0.0");

        lab_NDCY.setText("0.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lab_NDCX, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lab_NDCY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lab_NDCX))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lab_NDCY))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Coordenadas de saída"));

        lab_X.setText("X: 0");

        lab_Y.setText("Y: 0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab_X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lab_Y, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab_X)
                .addGap(18, 18, 18)
                .addComponent(lab_Y)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelFooterLayout = new javax.swing.GroupLayout(panelFooter);
        panelFooter.setLayout(panelFooterLayout);
        panelFooterLayout.setHorizontalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelFooterLayout.setVerticalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        panelGrafic.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lab_cTela.setText("Tela: 800x600");

        javax.swing.GroupLayout panelGraficLayout = new javax.swing.GroupLayout(panelGrafic);
        panelGrafic.setLayout(panelGraficLayout);
        panelGraficLayout.setHorizontalGroup(
            panelGraficLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGraficLayout.createSequentialGroup()
                .addContainerGap(690, Short.MAX_VALUE)
                .addComponent(lab_cTela, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelGraficLayout.setVerticalGroup(
            panelGraficLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGraficLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lab_cTela)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBoxLayout = new javax.swing.GroupLayout(panelBox);
        panelBox.setLayout(panelBoxLayout);
        panelBoxLayout.setHorizontalGroup(
            panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoxLayout.createSequentialGroup()
                .addComponent(panelGrafic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBoxLayout.setVerticalGroup(
            panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelGrafic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panMenuLayout = new javax.swing.GroupLayout(panMenu);
        panMenu.setLayout(panMenuLayout);
        panMenuLayout.setHorizontalGroup(
            panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );
        panMenuLayout.setVerticalGroup(
            panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        menuDesenhar.setText("Desenhar");

        jm_reta.setText("Reta");
        jm_reta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_retaActionPerformed(evt);
            }
        });
        menuDesenhar.add(jm_reta);

        jm_circ.setText("Circunferencia");
        jm_circ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_circActionPerformed(evt);
            }
        });
        menuDesenhar.add(jm_circ);

        jMenuBar1.add(menuDesenhar);

        menuTransformacoes.setText("Transformações");

        subMenu2d.setText("2D");
        subMenu2d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenu2dActionPerformed(evt);
            }
        });
        menuTransformacoes.add(subMenu2d);

        jMenuBar1.add(menuTransformacoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(panelBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelBoxMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBoxMouseMoved
        
    }//GEN-LAST:event_panelBoxMouseMoved

    private void subMenu2dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenu2dActionPerformed
       
        
        
        /*SubMenu2d view2d = new SubMenu2d();
        panMenu.add(view2d);
        view2d.setVisible(true);*/
    }//GEN-LAST:event_subMenu2dActionPerformed

    private void jm_retaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_retaActionPerformed
        panMenu.setVisible(true);

        if (!panelFooter.isValid()) {
            setDefaultBox();
        } else {
            PlanoCartesiano.getInstance().redesenha();
        }
        changePanMenu(panelMenuRaster);
    }//GEN-LAST:event_jm_retaActionPerformed

    private void jm_circActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_circActionPerformed
        panMenu.setVisible(true);
        
        if(!panelFooter.isValid()){
            setDefaultBox();
        } else {
            PlanoCartesiano.getInstance().redesenha();
        }
        changePanMenu(panelMenuCirc);
    }//GEN-LAST:event_jm_circActionPerformed
    
    private void coordinatesSystem(){
        panelGrafic.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseMoved(MouseEvent evt){
                super.mouseMoved(evt);
                PlanoCartesiano planoCartesiano = PlanoCartesiano.getInstance();
        
                int dcx = evt.getX() - planoCartesiano.getValorCentroX();
                int dcy = (evt.getY() - planoCartesiano.getValorCentroY())*-1;
                //System.out.println(evt.getX() + ", " + planoCartesiano.getValorCentroX());
                
                
                float ndcx = NormalizationsFunctions.calcNDCX(planoCartesiano.getLargura(), dcx);
                float ndcy = NormalizationsFunctions.calcNDCX(planoCartesiano.getAltura(), dcy);
                lab_cTela.setText("Tela: " + evt.getX() + ", " + evt.getY());

                lab_NDCX.setText(String.format("%.6f", ndcx));
                lab_NDCY.setText(String.format("%.6f", ndcy));

                lab_DCX.setText("DCX: " + String.valueOf(NormalizationsFunctions.calcDCX(planoCartesiano.getLargura(), ndcx)));
                lab_DCY.setText("DCY: " + String.valueOf(NormalizationsFunctions.calcDCY(planoCartesiano.getAltura(), ndcy)));

                lab_X.setText("X: " + String.valueOf(Math.round(dcx)));
                lab_Y.setText("Y: " + String.valueOf(Math.round(dcy)));
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JMenuItem jm_circ;
    private javax.swing.JMenuItem jm_reta;
    private javax.swing.JLabel lab_DCX;
    private javax.swing.JLabel lab_DCY;
    private javax.swing.JLabel lab_NDCX;
    private javax.swing.JLabel lab_NDCY;
    private javax.swing.JLabel lab_X;
    private javax.swing.JLabel lab_Y;
    private javax.swing.JLabel lab_cTela;
    private javax.swing.JMenu menuDesenhar;
    private javax.swing.JMenu menuTransformacoes;
    private javax.swing.JPanel panMenu;
    private javax.swing.JPanel panelBox;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JPanel panelGrafic;
    private javax.swing.JMenuItem subMenu2d;
    // End of variables declaration//GEN-END:variables

    
    private void openMenuReta(java.awt.event.ActionEvent evt) {                              
        panMenu.setVisible(true);

        if (!panelFooter.isValid()) {
            setDefaultBox();
        } else {
            PlanoCartesiano.getInstance().redesenha();
        }
        changePanMenu(panelMenuRaster);
    }
    
    private void setDefaultBox() {
        if (!panelFooter.isVisible()) {
            panelBox.removeAll();
            changePanelCentral(panelGrafic);

            javax.swing.GroupLayout panelBoxLayout = new javax.swing.GroupLayout(panelBox);
            panelBox.setLayout(panelBoxLayout);
            panelBoxLayout.setHorizontalGroup(
                    panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBoxLayout.createSequentialGroup()
                                    .addComponent(panelGrafic, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            panelBoxLayout.setVerticalGroup(
                    panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelGrafic, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                            .addComponent(panelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
            );
            panelFooter.setVisible(true);
        }
    }
    
    private void changePanelCentral(Component component) {
        javax.swing.GroupLayout panelBoxLayout = new javax.swing.GroupLayout(panelBox);
        panelBox.setLayout(panelBoxLayout);
        panelBoxLayout.setHorizontalGroup(
                panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBoxLayout.createSequentialGroup()
                                .addComponent(component, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
        );
        panelBoxLayout.setVerticalGroup(
                panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(component, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }
    
    public static void runResult(Object instance) {
        if (instance instanceof PanelMenuRaster) {
            processaRasterizacaoReta(PanelMenuRaster.getInstance());
        } else if (instance instanceof PanelMenuCircunferencia) {
            processaRasterizacaoCircunferencia(PanelMenuCircunferencia.getInstance());
        } /*else if (instance instanceof PanelMenu2D) {
            processaTransformacoes2D(PanelMenu2D.getInstance());
        } else if (instance instanceof PanelMenu3D) {
            processaTransformacoes3D(PanelMenu3D.getInstance());
        } else if (instance instanceof PanelMenuImagem) {
            processaTransformacoesImagem(PanelMenuImagem.getInstance());
        }*/
    }
    
    private static void processaRasterizacaoReta(PanelMenuRaster menu) {
        Rasterizacao rast = Rasterizacao.getInstance();
        PlanoCartesiano.getInstance().redesenha();

        if (menu.getTipoAlgoritimo().equals(RasterEnum.DDA)) {
            rast.dda(menu.getPontoInicial(), menu.getPontoFinal(), menu.getTextAreaResult());
        } else if (menu.getTipoAlgoritimo().equals(RasterEnum.PONTO_MEDIO)) {
            rast.bresenham(menu.getPontoInicial(), menu.getPontoFinal(), menu.getTextAreaResult());
        }
    }
    
    private static void processaRasterizacaoCircunferencia(PanelMenuCircunferencia menu) {
        Circunferencia circ = Circunferencia.getInstance();

        switch (menu.getTipoAlgoritimo()) {
            /*case PONTO_MEDIO:
                circ.funcaoPontoMedio((int) menu.getRaioX());
                break;*/
            case EQUACAO_EXPLICITA:
                circ.funcaoExplicita((int) menu.getRaioX());
                break;
            case TRIGONOMETRIA:
                circ.funcaoTrigonometrica((int) menu.getRaioX());
                break;
            /*case ELIPSE:
                circ.funcaoElipse((int) menu.getRaioX(), (int) menu.getRaioY());*/
            default:
                break;
        }
    }
    
    private void changePanMenu(JPanel panel) {
        panMenu.removeAll();
        panMenu.repaint();
        
        panMenu.setLayout(new GridLayout());
        panMenu.add(panel);

        panMenu.validate();
    }
    
}
