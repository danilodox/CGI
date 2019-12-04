/*
 * Essa é uma classe auxiliar que permite acessar os pontos
 * X, Y e Z nas operações.
 */
package auxiliar;

public class Ponto {
    
    private double x, y, z;
    
    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Ponto(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
    
    
}
