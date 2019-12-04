/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formas;

import operacoes.PlanoCartesiano;
import auxiliar.Ponto;
import javax.swing.JTextArea;

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
        x = pInicial.getX();
        y = pInicial.getY();
        planoCartesiano.drawPixel(x, y);
        setIteracao(textAreaSolution, x, y, ++cont, null);
        if(x < pFinal.getX()){
            while(x < pFinal.getX()){
                x = x + xin;
                y = y + yin;
                planoCartesiano.drawPixel(x, y);
                setIteracao(textAreaSolution, x, y, ++cont, null);
            }
        } else {
            while(x > pFinal.getX()){
                x = x + xin;
                y = y + yin;
                planoCartesiano.drawPixel(x, y);
                setIteracao(textAreaSolution, x, y, ++cont, null);
            }
        }
        
        
    }
    
    public void bresenham(Ponto p1, Ponto p2, JTextArea textAreaSolution){
	double x1, y1, x2, y2;
        int count = 0;
        int dx = Math.abs((int)p2.getX() - (int)p1.getX());
	int dy = Math.abs((int)p2.getY() - (int)p1.getY());

	//	oitantes 1, 4, 5, 8
	if (dy < dx) {
            int yInc;
            if (p2.getX() < p1.getX()){
                Ponto pAux = p1;
                p1 = p2;
                p2 = pAux;
            }
            x1 = p1.getX();
            x2 = p2.getX();
            y1 = p1.getY();
            y2 = p2.getY();
            if(y2 < y1){
                yInc = -1;
            } else {
                yInc = 1;
            }
            int p = 2*dy - dx;
            planoCartesiano.drawPixel(x1, y1);
            setIteracao(textAreaSolution, x1, y1, ++count, null);
            while (x1 < x2){
                if (p < 0){
                        p += 2*dy;
                }else{
                        p += 2*(dy-dx);
                        y1 += yInc;
                }
                x1++;
                planoCartesiano.drawPixel(x1, y1);
                setIteracao(textAreaSolution, x1, y1, ++count, null);
            }
	}else{	//	oitantes 2, 3, 6 e 7
            int xInc;
            if (p2.getY() < p1.getY()){
                Ponto pAux = p1;
                p1 = p2;
                p2 = pAux;
            }
            x1 = (int)p1.getX();
            x2 = (int)p2.getX();
            y1 = (int)p1.getY();
            y2 = (int)p2.getY();
            //	Inclinação negativa => xInc = -1
            if(x2 < x1){
                xInc = -1;
            } else {
                xInc = 1;
            }
            int p = 2*dx - dy;

            planoCartesiano.drawPixel(x1, y1);
            setIteracao(textAreaSolution, x1, y1, ++count, null);
            while (y1 < y2){
                if (p < 0){
                        p += 2*dx;
                }else{
                        p += 2*(dx-dy);
                        x1 += xInc;
                }
                y1++;
                planoCartesiano.drawPixel(x1, y1);
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
