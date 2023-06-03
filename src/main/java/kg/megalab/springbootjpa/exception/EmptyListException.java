package kg.megalab.springbootjpa.exception;

public class EmptyListException extends RuntimeException{

    public EmptyListException(String message) {
        super(message);
    }
}
