/*
 * Enumera as operação de rasterização da circunferencia.
 */
package enums;

public enum CircEnum {
    EQUACAO_EXPLICITA("Equação Explícita"), PONTO_MEDIO("Ponto Médio"), TRIGONOMETRIA("Trigonométrica"), ELIPSE("Elipse");
    
    private final String titulo;

    CircEnum(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }
}
