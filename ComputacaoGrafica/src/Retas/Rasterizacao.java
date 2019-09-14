/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retas;

import Opr.PlanoCartesiano;
import auxiliar.Ponto;
import java.awt.Color;
import javax.swing.JTextArea;

/**
 *
 * @author Peu
 */
public class Rasterizacao {
    
    private static Rasterizacao instance;

    private final PlanoCartesiano planoCartesiano;

    public Rasterizacao() {
        planoCartesiano = PlanoCartesiano.getInstance();
    }

    public static synchronized Rasterizacao getInstance() {
        if (instance == null) {
            instance = new Rasterizacao();
        }
        return instance;
    }
    
    public void dda(Ponto pInicial, Ponto pFinal, JTextArea textAreaSolution) {
        double x1 = pInicial.getX();
        double x2 = pFinal.getX();
        double y1 = pInicial.getY();
        double y2 = pFinal.getY();
        double dx = (x2 - x1);
        double dy = (y2 - y1);
        int count = 0;

        if (Math.abs(y2 - y1) <= Math.abs(x2 - x1)) {
            if ((x1 == x2) && (y1 == y2)) {
                planoCartesiano.drawPixel(x1, y1);
                setIteracao(textAreaSolution, x1, y1, ++count, null);
            } else {
                if (x2 < x1) {
                    double tmp = x2;
                    x2 = x1;
                    x1 = tmp;

                    tmp = y2;
                    y2 = y1;
                    y1 = tmp;
                }

                double k = dy / dx;
                int cele_y;
                double y = y1;

                /*for (int x = (int) x1; x <= x2; x++) {
                    cele_y = (int) Math.round(y);
                    planoCartesiano.drawPixel(x, cele_y);
                    setIteracao(textAreaSolution, x, cele_y, ++count, null);
                    y += k;
                }*/
            }
        } else if (y2 < y1) {
            double tmp = x2;
            x2 = x1;
            x1 = tmp;

            tmp = y2;
            y2 = y1;
            y1 = tmp;
        }

        double k = dx / dy;
        double x = x1;
        for (int y = (int) y1; y <= y2; y++) {
            planoCartesiano.drawPixel(x, y);
            setIteracao(textAreaSolution, x, y, ++count, null);
            x += k;
        }
    }
    
    public void pm(Ponto pInicial, Ponto pFinal, JTextArea textAreaSolution){
        System.out.println("EM CONSTRUCAO");
    }
    
    public static void setIteracao(JTextArea textAreaSolution, double x, double y, int count, String d){
        if (textAreaSolution != null) {
            StringBuilder solution = new StringBuilder();

            solution.append(textAreaSolution.getText());
            solution.append(String.format("%02d", count));
            solution.append("-> ");
            if (d != null) {
                solution.append("d = ").append(Math.round(Double.parseDouble(d))).append(", ");
            }
            solution.append("P(").append(Math.round(x)).append(", ").append(Math.round(y));
            solution.append(")\n");
            textAreaSolution.setText(solution.toString());
        }
    }
    
}
