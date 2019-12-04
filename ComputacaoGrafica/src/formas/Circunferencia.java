/*
 * Nessa classe temos as operações de rasteirização da circunferencia
 * que corresponde as operações explicita, trigonometrica e ponto medio.
 */
package formas;

import operacoes.PlanoCartesiano;
import auxiliar.Ponto;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

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
        //Define os passo e atribui os valores que serão verificados 
        int passosD = 0, passosU = 0;
        if(raio % 2 == 0){
            passosD = Math.floorDiv(raio + 1, 2);
            passosU = (int) (((raio + 1)/2) + ((raio + 1) % 2));
        } else {
            passosD = Math.floorDiv(raio, 2);
            passosU = (int) ((raio /2) + (raio % 2));
        }
        
        //Testa se os passos iniciais i é menor que i2, parando caso positivo
        int i=0, i2 = passosU;
        while(i<passosD){
            //Realiza os incrementos
            int yAux = (int) Math.sqrt((raio * raio) - (i * i));
            int yAux2 = (int) Math.sqrt((raio * raio) - (i2 * i2));
            //Desenha os pontos utilizando a simetria de 8
            drawPoints2(i, yAux);
            drawPoints2(i2, yAux2);
            i++;
            i2++;
        }
    }
    
    //Seu funcionamento é similar a função explicita, no entanto utiliza o angulo 
    //para determinar os pontos ao inves do raio.
    public void funcaoTrigonometrica(int raio){
        planoCartesiano.redesenha();
        for(int i = 0 ; i <= 45 ; i++){
            System.out.println(raio* (double) Math.cos(Math.toRadians(i)));
            g.fillRect(((int) (raio * (double) Math.cos(Math.toRadians(i)))) + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - ((int) (raio * (double) Math.sin(Math.toRadians(i)))), 1, 1);
            drawPoints(((int) (raio * (double) Math.cos(Math.toRadians(i)))), -((int) (raio * (double) Math.sin(Math.toRadians(i)))));
        }
    }
    
    //a estratégia é selecionar entre 2 pixels na malha aquele que está 
    //mais próximo da circunferência, utilizando o sinal da função no ponto 
    //intermediário entre os dois possíveis pixels.
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
    
    //Desenha os pixels usando a simetria de 8
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
    
    public void drawPoints2(int x, int y){
        g.fillRect(planoCartesiano.getValorCentroX() + x, planoCartesiano.getValorCentroY() + y, 1, 1);
        g.fillRect(planoCartesiano.getValorCentroX() - x, planoCartesiano.getValorCentroY() + y, 1, 1);
        g.fillRect(planoCartesiano.getValorCentroX() + x, planoCartesiano.getValorCentroY() - y, 1, 1);
        g.fillRect(planoCartesiano.getValorCentroX() - x, planoCartesiano.getValorCentroY() - y, 1, 1);
    }
}
