/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formas;

import operacoes.PlanoCartesiano;
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
    //dda antigo
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
    //dda novo(baseado no codigo do slide)
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
    
    //algoritmo de ponto medio
    
    //código antigo, deixado como legado apenas para caso haja algum problema
    /*public void bresenhamX(Ponto pInicial, Ponto pFinal, JTextArea textAreaSolution){
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
    }*/
    
    
    //Codigo de bresenhan novo baseado no slide
    /*public void bresenhamX(Ponto pInicial, Ponto pFinal, JTextArea textAreaSolution){
        int x1 = (int)(pInicial.getX());
        int x2 = (int)(pFinal.getX());
        int y1 = (int)(pInicial.getY());
        int y2 = (int)(pFinal.getY());
        double dx = Math.abs(x2 - x1), dy = Math.abs(y2 - y1);
        double x, y;
        double p = 2 * dy - dx;
        double twoDy = 2 * dy, twoDyMinusDx = 2* (dy - dx);
        
        if(x1 > x2){
            x = x2;
            y = y2;
            x2 = x1;
        } else {
            x = x1;
            y = y1;
        }
        int count = 0;
        planoCartesiano.drawPixel(x, y);
        setIteracao(textAreaSolution, x, y, ++count, null);
        while(x < x2){
            //x++;
            System.out.println(p);
            if( p < 0){
                x++;
                p += twoDy;
            } else {
                y++;
                p -= twoDyMinusDx;
            }
            planoCartesiano.drawPixel(x, y);
            setIteracao(textAreaSolution, x, y, ++count, null);
        }
    }*/
    
    public void bresenhamX(int x1, int x2, int y1, int y2, JTextArea textAreaSolution){
        int dx = x2 - x1;
        int dy = y2 - y1;
        int d = 2 * dy - dx;
        
        int incE = 2 * dy;
        int incNE = 2 * (dy - dx);
        
        double x = x1;
        double y = y1;
        
        int count = 0;
        
        planoCartesiano.drawPixel(x, y);
        setIteracao(textAreaSolution, x, y, ++count, null);
        
        while(x < x2){
            if(d <= 0){
                d += incE;
                x++;
            }else{
                d += incNE;
                x++;
                y++;
            }
            planoCartesiano.drawPixel(x, y);
            setIteracao(textAreaSolution, x, y, ++count, null);
        }
        
    }
    
     public void bresenhamY(int x1, int x2, int y1, int y2, JTextArea textAreaSolution){
        int dx = x2 - x1;
        int dy = y2 - y1;
        int d = 2 * dx - dy;
        
        int incE = 2 * dx;
        int incNE = 2 * (dx - dy);
        
        double x = x1;
        double y = y1;
        
        int count = 0;
        
        planoCartesiano.drawPixel(x, y);
        setIteracao(textAreaSolution, x, y, ++count, null);
        
        while(y < y2){
            if(d <= 0){
                d += incE;
                y++;
            }else{
                d += incNE;
                x++;
                y++;
            }
            planoCartesiano.drawPixel(x, y);
            setIteracao(textAreaSolution, x, y, ++count, null);
        }
        
    }
    
    //DESCOBRIR COMOTESTAR OS OCTANTES
    public void octante(Ponto pInicial, Ponto pFinal, JTextArea textAreaSolution){
        
        if(Math.abs(pFinal.getX()-pInicial.getX()) > Math.abs(pFinal.getY()-pInicial.getY())){
            System.out.println("Entrou no if");
            if(pFinal.getX() < pInicial.getX() && pFinal.getY() > pInicial.getY()){
                //TALVEZ INVERTER OS 2 PONTOS
                System.out.println("Entrou no if2");
                bresenhamX((int)pFinal.getX(), (int)pInicial.getX(), (int)pInicial.getY(), (int)pFinal.getY(), textAreaSolution);
            }else if(pFinal.getX() < pInicial.getX() && pFinal.getY() < pInicial.getY()){
                //REVER
                System.out.println("Entrou no if3");
                bresenhamX((int)pFinal.getX(), (int)pInicial.getX(), (int)pInicial.getY(), (int)pFinal.getY(), textAreaSolution);
            }else if(pFinal.getX() > pInicial.getX() && pFinal.getY() > pInicial.getY()){
                System.out.println("Entrou no if4");
                bresenhamX((int)pInicial.getX(), (int)pFinal.getX(), (int)pInicial.getY(), (int)pFinal.getY(), textAreaSolution);
            }else if(pFinal.getX() > pInicial.getX() && pFinal.getY() < pInicial.getY()){
                //REVER
                System.out.println("Entrou no if5");
                bresenhamX((int)pInicial.getX(), (int)pFinal.getX(), (int)pInicial.getY(), (int)pFinal.getY(), textAreaSolution);
            }
        }else if(Math.abs(pFinal.getX()-pInicial.getX()) < Math.abs(pFinal.getY()-pInicial.getY())){
            if(pFinal.getX() < pInicial.getX() && pFinal.getY() > pInicial.getY()){
               //REVER
                System.out.println("Entrou no if6");
                bresenhamY((int)pInicial.getX(), (int)pFinal.getX(), (int)pInicial.getY(), (int)pFinal.getY(), textAreaSolution);
            }else if(pFinal.getX() < pInicial.getX() && pFinal.getY() < pInicial.getY()){
                //REVER
                System.out.println("Entrou no if7");
                bresenhamY((int)pInicial.getX(), (int)pFinal.getX(), (int)pFinal.getY(), (int)pInicial.getY(), textAreaSolution);
            }else if(pFinal.getX() > pInicial.getX() && pFinal.getY() > pInicial.getY()){
                System.out.println("Entrou no if8");
                bresenhamY((int)pInicial.getX(), (int)pFinal.getX(), (int)pInicial.getY(), (int)pFinal.getY(), textAreaSolution);
            }else if(pFinal.getX() > pInicial.getX() && pFinal.getY() < pInicial.getY()){
                //TALVEZ INVERTER OS 2 PONTOS
                System.out.println("Entrou no if9");
                bresenhamY((int)pInicial.getX(), (int)pFinal.getX(), (int)pFinal.getY(), (int)pInicial.getY(), textAreaSolution);
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
