/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacoes;

import enums.Eixo;
import operacaoMatrizes.Matriz;
import panels.SubMenuTransfor2d;

/**
 *
 * @author aline
 */
public class Transformacoes2D {
    
    private static Transformacoes2D instance;
    private double[][] matrizM;
    
    private Transformacoes2D(){
        
    }
    
    public static synchronized Transformacoes2D getInstance(){
        if(instance == null){
            instance = new Transformacoes2D();
        }
        return instance;
    }
    
    public double[][] translacao(double[][] matrizObject, double tx, double ty){
        double[][] matrizResult = new double[matrizObject.length][matrizObject[0].length];
        
        try{
            matrizResult = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty), matrizObject);
            SubMenuTransfor2d.matrizObject = matrizResult;
        }catch(Exception e){
            System.err.println("Ocorreu um erro na tranformacao");
        }
        return matrizResult;
    }
    
    public double[][] escala(double[][] matrizObject, double sx, double sy){
        double[][] matrizResult = new double[matrizObject.length][matrizObject[0].length];
        
        double tx = matrizObject[0][0];
        double ty = matrizObject[1][0];
        
        try{
            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty), geraMatrizEscala(sx, sy));
            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty));
            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObject);

            ///FALTA CRIAR ESSE CAMPO NO PanelMenu2D
            SubMenuTransfor2d.matrizObject = matrizResult;
            
        }catch(Exception e){
            System.err.println("Ocorreu um erro na tranformacao");
        }
        return matrizResult;
    }
    
        public double[][] rotacao(double[][] matrizObject, double angulo) {
        double[][] matrizResult = new double[matrizObject.length][matrizObject[0].length];

        // Fatores de translaÃ§Ã£o.
        double tx = matrizObject[0][0], ty = matrizObject[1][0];

        try {

            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty), geraMatrizRotacao(angulo));
            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty));
            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObject);

            ///FALTA CRIAR ESSE CAMPO NO PanelMenu2D
            SubMenuTransfor2d.matrizObject = matrizResult;
            
        } catch (Exception e) {
            System.err.println("Ocorreu um erro na transformacao!");
        }
        return matrizResult;
    }
       
    public double[][] reflexao(double[][] matrizObject, String eixo) {
        double[][] matrizResult = new double[matrizObject.length][matrizObject[0].length];
        eixo = eixo.toUpperCase();

        try {
            matrizResult = Matriz.multiplicaMatrizes(geraMatrizReflexao(eixo), matrizObject);
           
            ///FALTA CRIAR ESSE CAMPO NO PanelMenu2D
            SubMenuTransfor2d.matrizObject = matrizResult;
            
        } catch (Exception e) {
            System.err.println("Ocorreu um erro na reflexao em: " + eixo + "!");
        }
        return matrizResult;
    }
    
        public double[][] cisalhamento(double[][] matrizObject, double cx, double cy) {
        double[][] matrizResult = new double[matrizObject.length][matrizObject[0].length];
        double tx = matrizObject[0][0], ty = matrizObject[1][0];

        try {
           
            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty), geraMatrizCisalhamento(cx, cy));
            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty));
            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObject);

            ///FALTA CRIAR ESSE CAMPO NO PanelMenu2D
            SubMenuTransfor2d.matrizObject = matrizResult;
        } catch (Exception e) {
            System.err.println("Ocorreu um erro no cisalhamento!");
        }

        return matrizResult;
    }
    
    public double[][] geraMatrizTranslacao(double tx, double ty) {
        double[][] matriz = new double[3][3];

        matriz[0][0] = 1;
        matriz[0][1] = 0;
        matriz[0][2] = tx;

        matriz[1][0] = 0;
        matriz[1][1] = 1;
        matriz[1][2] = ty;

        matriz[2][0] = 0;
        matriz[2][1] = 0;
        matriz[2][2] = 1;

        return matriz;
    }
    
        public double[][] geraMatrizEscala(double sx, double sy) {
        double[][] matriz = new double[3][3];
        sx = (sx == 0) ? 1 : sx;
        sy = (sy == 0) ? 1 : sy;

        matriz[0][0] = sx;
        matriz[1][0] = 0;
        matriz[2][0] = 0;

        matriz[0][1] = 0;
        matriz[1][1] = sy;
        matriz[2][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }
        
    public double[][] geraMatrizRotacao(double angulo) {
        double[][] matriz = new double[3][3];

        double sen = Math.sin(Math.toRadians(angulo));
        double cos = Math.cos(Math.toRadians(angulo));

        matriz[0][0] = cos;
        matriz[1][0] = sen;
        matriz[2][0] = 0;

        matriz[0][1] = -sen;
        matriz[1][1] = cos;
        matriz[2][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }
    
    public double[][] geraMatrizReflexao(String eixo) {
        double[][] matriz = new double[3][3];

        eixo = eixo.toUpperCase();
        
        matriz[0][0] = -1;
        matriz[1][0] = 0;
        matriz[2][0] = 0;

        matriz[0][1] = 0;
        matriz[1][1] = -1;
        matriz[2][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        if(eixo.equals(Eixo.X.getValue())) {
            matriz[0][0] = 1;
        } else if (eixo.equals(Eixo.Y.getValue())) {
            matriz[1][1] = 1;
        } else if (eixo.equals(Eixo.XY.getValue())) {
            matriz[0][0] = 0;
            matriz[1][0] = 1;
            
            matriz[0][1] = 1;
            matriz[1][1] = 0;
        }

        return matriz;
    }
    
    public double[][] geraMatrizCisalhamento(double cx, double cy) {
        double[][] matriz = new double[3][3];

        matriz[0][0] = 1;
        matriz[1][0] = cy;
        matriz[2][0] = 0;

        matriz[0][1] = cx;
        matriz[1][1] = 1;
        matriz[2][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }
        
}
