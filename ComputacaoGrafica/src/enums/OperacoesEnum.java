/*
 * Enumera as operação que serão usadas.
 */
package enums;

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
