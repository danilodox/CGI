/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oprMatrizes;

/**
 *
 * @author Peu
 */
public class MultiplicarMatriz {
    
    /*private double[][] m1, m2;
    
    public MultiplicarMatriz(double[][] m1, double[][] m2){
        this.m1 = m1;
        this.m2 = m2;
    }

    public double[][] getM1() {
        return m1;
    }

    public void setM1(double[][] m1) {
        this.m1 = m1;
    }

    public double[][] getM2() {
        return m2;
    }

    public void setM2(double[][] m2) {
        this.m2 = m2;
    }*/
    
    /*
    1, 2, 3
    4, 5, 6
    
    1, 2
    3, 4
    5, 6
    
    22, 28
    49, 64
    m1.length*m1.length*m1[0].length;
    */
    public static void multM(double[][] m1, double[][] m2){
        int n = m1[0].length; //A.columns = B.rows
        //Verfica se A.columns = B.rows
        int rows = m1.length; //A.rows
        int cols = m2[0].length; //B.columns
        double[][] C = new double[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                for(int k = 0; k < n; k++){
                    C[i][j] = C[i][j] + m1[i][k] * m2[k][j];
                }
            }
        }
        printR(C);
    }
    
    public static void printR(double[][] c){
        for(int i=0;i<c.length; i++){
            for(int k=0;k<c[i].length; k++){
                System.out.print(c[i][k] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        double[][] k = new double[2][3];
        double[][] j = new double[3][2];
        k[0][0] = 1;
        k[0][1] = 2;
        k[0][2] = 3;
        
        k[1][0] = 4;
        k[1][1] = 5;
        k[1][2] = 6;
        
        j[0][0] = 1;
        j[0][1] = 2;
        
        j[1][0] = 3;
        j[1][1] = 4;
        
        j[2][0] = 5;
        j[2][1] = 6;
        multM(k, j);
    }
}
