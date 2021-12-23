package br.com.fmarxds.apiecommerce.exception;

public class EnderecoNaoEncontradoException extends Exception {

    public EnderecoNaoEncontradoException(String message) {
        super(message);
    }

    public EnderecoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

}
