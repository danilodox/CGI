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
public enum TransformacoesImagemEnum {
    NEGATIVO("Negativo"), GAMMA("Gamma"), LOG("Logaritmo");

    private final String titulo;

    TransformacoesImagemEnum(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
