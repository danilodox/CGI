/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author aline
 */
public enum Eixo {
    X("X"), Y("Y"), Z("Z"), XY("XY"), XZ("XZ"), YZ("YZ");
    
    private final String value;

    Eixo(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}
