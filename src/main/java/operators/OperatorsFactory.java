package operators;

import exceptions.CommandExecutionException;
import exceptions.WrongCommandFormatException;

public interface OperatorsFactory {
    void action(ExecutionContext context, String[] args) throws CommandExecutionException, WrongCommandFormatException;
}
