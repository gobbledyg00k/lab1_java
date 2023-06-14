package operators;

import exceptions.CommandExecutionException;

public class Print implements OperatorsFactory {
    @Override
    public void action(ExecutionContext context, String[] args) throws CommandExecutionException {
        System.out.println(context.stackPeek());
    }
}
