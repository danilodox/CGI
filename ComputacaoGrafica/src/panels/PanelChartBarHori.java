/*
 * 
 */
package panels;

import java.awt.BorderLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class PanelChartBarHori extends javax.swing.JPanel {

    /**
     * Creates new form PanelChartBarHori
     */
    public PanelChartBarHori() {
        initComponents();
        populaGrafico();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    /**
     * Cria o gráfico e adiciona ao panel
     */
    private void populaGrafico() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Grafico Bar Horizontal",
                "",
                "",
                createDataset(),
                PlotOrientation.HORIZONTAL,
                true, true, false);

        // Pega a instancia do plot para personalizar
        final CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setLayout(new java.awt.BorderLayout());
        add(chartPanel, BorderLayout.CENTER);
    }
    
    /**
     * Popula os dados do gráfico
     * 
     * @return CategoryDataset
     */
    private CategoryDataset createDataset() {
        final String frequencia = "Frenquência";
        final String porcentagem = "Porcentagem";
        final String provedorA = "Provedor A";
        final String provedorB = "Provedor B";
        final String provedorC = "Provedor C";
        final String provedorD = "Provedor D";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(10.0, frequencia, provedorA);
        dataset.addValue(17.0, frequencia, provedorB);
        dataset.addValue(7.0, frequencia, provedorC);
        dataset.addValue(6.0, frequencia, provedorD);

        dataset.addValue(25.0, porcentagem, provedorA);
        dataset.addValue(42.5, porcentagem, provedorB);
        dataset.addValue(17.5, porcentagem, provedorC);
        dataset.addValue(15.0, porcentagem, provedorD);

        return dataset;
    }
    
}
