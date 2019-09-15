/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retas;

import Operacoes.PlanoCartesiano;
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
}
