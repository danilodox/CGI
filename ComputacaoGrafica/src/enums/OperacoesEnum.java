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
public enum OperacoesEnum {
    ADICAO("Adição"), SUBSTRACAO("Substração"), MULTIPLICACAO("Multiplicação"), 
    DIVISAO("Divisão"), OR("OR"), XOR("XOR"), AND("AND");
    
    private final String titulo;
    
    OperacoesEnum(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
