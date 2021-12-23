package br.com.fmarxds.apiecommerce.exception;

public class EstoqueNaoBaixadoException extends Exception {

    public EstoqueNaoBaixadoException(String message) {
        super(message);
    }

    public EstoqueNaoBaixadoException(String message, Throwable cause) {
        super(message, cause);
    }

}
