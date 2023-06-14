package exceptions;

public class WrongCommandFormatException extends Exception {
    public WrongCommandFormatException(String message){
        super(message);
    }
}
