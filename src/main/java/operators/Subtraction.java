package operators;

import exceptions.CommandExecutionException;

public class Subtraction implements OperatorsFactory {
    @Override
    public void action(ExecutionContext context, String[] args) throws CommandExecutionException {
        Double a = context.stackPop();
        Double b = context.stackPop();
        context.stackPush(b - a);
    }
}
