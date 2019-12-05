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
public enum MorfologiaBinEnum {
    DILATACAO("Dilatacao"), EROSAO("Erosao"), FECHAMENTO("Fechamento"), ABERTURA("Abertura"), HITORMISS("Hit or Miss"), 
    CONTORNOEXTERNO("Contorno externo"), CONTORNOINTERNO("Contorno interno"), GRADIENTEMORFOLOGICO("Gradiente morfologico");
    
    private final String titulo;

    MorfologiaBinEnum(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
