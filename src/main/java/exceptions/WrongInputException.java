package exceptions;

public class WrongInputException extends WrongCommandFormatException{
    public WrongInputException(String message) {
        super(message);
    }
}
