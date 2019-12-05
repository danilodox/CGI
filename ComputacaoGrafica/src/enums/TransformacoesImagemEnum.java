/*
 * Enumera os efeitos de transformação de imagens.
 */
package enums;

public enum TransformacoesImagemEnum {
    NEGATIVO("Negativo"), GAMMA("Gamma"), LOG("Logaritmo"), ITFSIGMOIDE("ITF Sifmoide"), FAIXADINAMICA("Faixa Dinamica"), 
    TRANSFERENCIALINEAR("Transferencia Linear");

    private final String titulo;

    TransformacoesImagemEnum(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
