package operators;

import exceptions.CommandExecutionException;

public class StackPop implements OperatorsFactory {
    @Override
    public void action(ExecutionContext context, String[] args) throws CommandExecutionException {
        context.stackPop();
    }
}
