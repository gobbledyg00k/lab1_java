package exceptions;

public class DivByZeroException extends ArithmeticException{
    public DivByZeroException(String message) {
        super(message);
    }
}
