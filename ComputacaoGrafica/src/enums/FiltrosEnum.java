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
public enum FiltrosEnum {
    MEDIA("Média"), MEDIANA("MEDIANA"), PASSA_ALTA_BASICO("Passa alta básico"), 
    OPERADOR_ROBERTS("Operador de Robert’s"), OPERADOR_ROBERTS_CRUZADO("Operador de Robert’s Cruzado"),OPERADOR_PEWITT("Operador de Prewitt"), 
    ALTO_REFORCO("Alto Reforço (Hight-Boost)"), OPERADOR_SOBEL("Operador de Sobel");

    private final String titulo;

    FiltrosEnum(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
