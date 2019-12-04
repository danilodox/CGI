/*
 * Essa classe realiza as operações de normalização dos pontos
 */
package operacoes;

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
