/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacaoMatrizes;

/**
 *
 * @author Peu
 */
public class Matriz {
    
    public static double[][] multiplicaMatrizes(double[][] m1, double[][] m2){
        int n = m1[0].length; //A.columns = B.rows
        //Verfica se A.columns = B.rows
        int rows = m1.length; //A.rows
        int cols = m2[0].length; //B.columns
        System.out.println("matriz1: " + m1.length + ", " + m1[0].length);
        System.out.println("matriz2: " + m2.length + ", " + m2[0].length);
        double[][] C = new double[rows][cols];
        System.out.println("matrizf: " + C.length + ", " + C[0].length);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                for(int k = 0; k < n; k++){
                    C[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return C;
    }
    
    /**
     * Imprime valores da matriz passada como parâmetro.
     * 
     * @param matriz 
     * @param title 
     */
    public static void printMatriz(double[][] matriz, String title) {
        System.out.println("======== " + title.toUpperCase() + " ======== ");
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    
        
    /**
     * Imprime valores da matriz passada como parâmetro.
     * 
     * @param matriz 
     * @param title 
     */
    public static void printMatriz(int[][] matriz, String title) {
        System.out.println("======== " + title.toUpperCase() + " ======== ");
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
}
