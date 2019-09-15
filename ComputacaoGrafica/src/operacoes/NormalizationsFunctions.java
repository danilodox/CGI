/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacoes;

/**
 *
 * @author Peu
 */
public class NormalizationsFunctions {
    
    private static float ndcx;
    private static float ndcy;
    private static float dcx;
    private static float dcy;

    public static float calcNDCX(float ndh, float dcx) {
        ndcx = dcx / (ndh - 1);
        return ndcx;
    }

    public static float calcNDCY(float ndv, float dcy) {
        ndcy = (dcy / (ndv - 1));
        return ndcy;
    }

    public static int calcDCX(float ndh, float ndcx) {
        dcx = ((ndh - 1) * ndcx);
        return Math.round(dcx);
    }

    public static int calcDCY(float ndv, float ndcy) {
        dcy = ((ndv - 1) * ndcy);
        return Math.round(dcy);
    }
    
}
