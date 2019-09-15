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
    
    public double[][] multM(double[][] m1, double[][] m2){
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
        return C;
    }
}
