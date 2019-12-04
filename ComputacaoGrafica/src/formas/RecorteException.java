/*
 * Classe que verifica as exceções durante o recorte da linha no viewport
 */
package formas;

public class RecorteException extends Exception{
    public RecorteException(String message) {
        super(message);
    }
}
