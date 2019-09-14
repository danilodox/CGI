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
