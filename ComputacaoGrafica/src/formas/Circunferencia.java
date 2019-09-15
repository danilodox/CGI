/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formas;

import operacoes.PlanoCartesiano;
import auxiliar.Ponto;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Peu
 */
public class Circunferencia {
    private static Circunferencia instance;

    private final PlanoCartesiano planoCartesiano;
    private final Graphics g;

    public static int x, y, d_old, x_dif, y_dif;
    private List<Ponto> listaPontos;
    
    private Circunferencia() {
        listaPontos = new ArrayList<>();
        planoCartesiano = PlanoCartesiano.getInstance();
        g = planoCartesiano.getGraphics();
    }
    
    public static synchronized Circunferencia getInstance() {
        if (instance == null) {
            instance = new Circunferencia();
        }
        return instance;
    }
    
    public void funcaoExplicita(int raio) {
        planoCartesiano.redesenha();
        
        for (int i = -raio; i < raio; i++) {
            g.fillRect(i + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - ((int) Math.sqrt(raio * raio - i * i)), 1, 1);
            g.fillRect(i + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - (-1 * (int) Math.sqrt(raio * raio - i * i)), 1, 1);
        }
    }
    
    public void funcaoTrigonometrica(int raio){
        planoCartesiano.redesenha();
        for(int i = -raio ; i <= raio ; i++){
            g.fillRect(((int) (raio * (double) Math.cos(Math.toRadians(i)))) + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - ((int) (raio * (double) Math.sin(Math.toRadians(i)))), 1, 1);
            drawPoints(((int) (raio * (double) Math.cos(Math.toRadians(i)))), -((int) (raio * (double) Math.sin(Math.toRadians(i)))));
        }
    }
    
    public void funcaoPontoMedio(int raio){
        planoCartesiano.redesenha();
        
        x = 0;
        y = raio;
        d_old = 1 - raio;
        g.fillRect(planoCartesiano.getValorCentroX() + x, planoCartesiano.getValorCentroY() - y, 1, 1);
        drawPoints(x, y);
        while(y > x){
            if(d_old < 0){
                d_old += 2*x + 3;
            } else if(d_old >= 0) {
                d_old += 2*x - 2*y + 5;
                y--;
            }
            x++;
            drawPoints(x, y);
        }
    }
    
    public void drawPoints(int x, int y){
        g.fillRect(planoCartesiano.getValorCentroX() - x, planoCartesiano.getValorCentroY() + y, 1, 1);
        g.fillRect(planoCartesiano.getValorCentroX() + x, planoCartesiano.getValorCentroY() + y, 1, 1);
        g.fillRect(planoCartesiano.getValorCentroX() + x, planoCartesiano.getValorCentroY() - y, 1, 1);
        g.fillRect(planoCartesiano.getValorCentroX() - x, planoCartesiano.getValorCentroY() - y, 1, 1);
        
        g.fillRect(planoCartesiano.getValorCentroX() - y, planoCartesiano.getValorCentroY() + x, 1, 1);
        g.fillRect(planoCartesiano.getValorCentroX() + y, planoCartesiano.getValorCentroY() + x, 1, 1);
        g.fillRect(planoCartesiano.getValorCentroX() + y, planoCartesiano.getValorCentroY() - x, 1, 1);
        g.fillRect(planoCartesiano.getValorCentroX() - y, planoCartesiano.getValorCentroY() - x, 1, 1);
    }
}
