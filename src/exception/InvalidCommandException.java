package exception;

public class InvalidCommandException extends RuntimeException{
    public InvalidCommandException(String massage){
        super(massage);
    }
}
