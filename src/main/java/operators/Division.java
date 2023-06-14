package operators;

import exceptions.CommandExecutionException;
import exceptions.DivByZeroException;

public class Division implements OperatorsFactory {
    @Override
    public void action(ExecutionContext context, String[] args) throws CommandExecutionException {
        Double a = context.stackPop();
        Double b = context.stackPop();
        if (a == 0.0) {
            System.err.println("Division by zero");
            throw new DivByZeroException("Division by zero");
        }
        context.stackPush(b / a);
    }
}
