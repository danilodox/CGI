/*
 * Enumera as operações de transformação.
 */
package enums;

public enum TransformEnum {
    TRANSLACAO("Translação"), ESCALA("Escala"), ROTACAO("Rotação"), REFLEXAO("Reflexão"), CISALHAMENTO("Cisalhamento"), COMPOSTA("Composta");

    private final String titulo;

    TransformEnum(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
