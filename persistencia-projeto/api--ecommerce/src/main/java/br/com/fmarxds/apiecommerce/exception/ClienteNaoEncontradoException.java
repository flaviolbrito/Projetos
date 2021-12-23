package br.com.fmarxds.apiecommerce.exception;

public class ClienteNaoEncontradoException extends Exception {

    public ClienteNaoEncontradoException(String message) {
        super(message);
    }

    public ClienteNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

}
