/*
 * Enumera as operações de rasteirização da reta.
 */
package enums;

public enum RasterEnum {
    DDA("DDA (Digital Differential Analyser)"), PONTO_MEDIO("Bresenham (Ponto Médio)");
    
    private final String titulo;

    RasterEnum(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }
}
