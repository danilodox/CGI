/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retas;

import Operacoes.PlanoCartesiano;
import auxiliar.Ponto;
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
    
    public void ddaT(Ponto pInicial, Ponto pFinal, JTextArea textAreaSolution) {
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
    
    public void dda(Ponto pInicial, Ponto pFinal, JTextArea textAreaSolution){
        int passos, cont = 0;
        double x, y, xin, yin, dx, dy;
        dx = (pFinal.getX() - pInicial.getX());
        dy = (pFinal.getY() - pInicial.getY());
        if(Math.abs(dx) > Math.abs(dy)){
            passos = (int) Math.abs(dx);
        } else {
            passos = (int) Math.abs(dy);
        }
        xin = dx/passos;
        yin = dy/passos;
        if(pInicial.getX() > pFinal.getX()){
            x = pInicial.getX();
            y = pInicial.getY();
            planoCartesiano.drawPixel(x, y);
            setIteracao(textAreaSolution, x, y, ++cont, null);
            while(x > pFinal.getX()){
                x = x + xin;
                y = y + yin;
                planoCartesiano.drawPixel(x, y);
                setIteracao(textAreaSolution, x, y, ++cont, null);
            }
        } else {
            x = pFinal.getX();
            y = pFinal.getY();
            planoCartesiano.drawPixel(x, y);
            setIteracao(textAreaSolution, x, y, ++cont, null);
            while(x > pInicial.getX()){
                x = x - xin;
                y = y - yin;
                planoCartesiano.drawPixel(x, y);
                setIteracao(textAreaSolution, x, y, ++cont, null);
            }
        }
        
    }
    
    //algoritmo de ponto medio
    public void bresenham(Ponto pInicial, Ponto pFinal, JTextArea textAreaSolution){
        int x1 = (int)(pInicial.getX());
        int x2 = (int)(pFinal.getX());
        int y1 = (int)(pInicial.getY());
        int y2 = (int)(pFinal.getY());
        
        if((x1==x2) && (y1==y2)){
            planoCartesiano.drawPixel(x1, y1);
        }else {
            double dx = Math.abs(x2 - x1);
            double dy = Math.abs(y2 - y1);
            double rozdil = dx - dy;
            int posun_x, posun_y;

            if (x1 < x2) {
                posun_x = 1;
            } else {
                posun_x = -1;
            }
            if (y1 < y2) {
                posun_y = 1;
            } else {
                posun_y = -1;
            }

            int count = 0;
            planoCartesiano.drawPixel((double) x1, (double) y1); // Pinta o primeiro ponto
            setIteracao(textAreaSolution, x1, y1, ++count, null);

            while ((x1 != x2) || (y1 != y2)) {
                double p = 2 * rozdil;

                if (p > -dy) {
                    rozdil = rozdil - dy;
                    x1 = x1 + posun_x;
                }
                if (p < dx) {
                    rozdil = rozdil + dx;
                    y1 = y1 + posun_y;
                }

                planoCartesiano.drawPixel((double) x1, (double) y1);
                setIteracao(textAreaSolution, x1, y1, ++count, null);
            }
        }
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
