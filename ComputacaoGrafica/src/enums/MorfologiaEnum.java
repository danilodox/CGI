/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Peu
 */
public enum MorfologiaEnum {
    DILATACAO("Dilatacao"), EROSAO("Erosao"), GRADIENTEMORFOLOGICO("Gradiente morfologico"), ABERTURA("Abertura"), 
    FECHAMENTO("Fechamento"), TOPHAT("Top-Hat"), BOTTOMHAT("Bottom-Hat");

    private final String titulo;

    MorfologiaEnum(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
