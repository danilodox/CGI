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
