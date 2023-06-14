package exceptions;

public class ArgumentsException extends WrongCommandFormatException{
    public ArgumentsException(String message) {
        super(message);
    }
}
