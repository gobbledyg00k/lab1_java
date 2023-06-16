package operatorsTest;

import exceptions.CommandExecutionException;
import exceptions.EmptyValStackException;
import operators.ExecutionContext;
import operators.Print;
import org.junit.Test;

public class PrintTest {
    // tests for PrintCommand Class:

    @Test
    public void simplePrintTest() throws CommandExecutionException {
        ExecutionContext context = new ExecutionContext();
        context.stackPush(111d);

        Print printCommand = new Print();
        printCommand.action(context, new String[] {"PRINT"});
    }

    @Test (expected = EmptyValStackException.class)
    public void notEnoughStackElementsPrintTest() throws CommandExecutionException {
        ExecutionContext context = new ExecutionContext();

        Print printCommand = new Print();
        printCommand.action(context, new String[] {"PRINT"});
    }
}
