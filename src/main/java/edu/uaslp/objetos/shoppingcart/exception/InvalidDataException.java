package edu.uaslp.objetos.shoppingcart.exception;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException()
    {
        super("Null or empty string not allowed for item code");
    }
    public InvalidDataException(String mensaje)
    {
        super(mensaje);
    }
}
