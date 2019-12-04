/*
 * Essa classe realiza operações entre matrizes, como a multiplicação.
 */
package operacaoMatrizes;

public class Matriz {
    
    public static double[][] multiplicaMatrizes(double[][] m1, double[][] m2){
        int n = m1[0].length; //A.columns = B.rows
        //Verfica se A.columns = B.rows
        int rows = m1.length; //A.rows
        int cols = m2[0].length; //B.columns
        double[][] C = new double[rows][cols];
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
