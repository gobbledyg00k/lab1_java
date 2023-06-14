package operatorsTest;

import exceptions.*;
import operators.ExecutionContext;
import operators.StackPop;
import org.junit.Assert;
import org.junit.Test;

public class PopTest {
    //tests for PopCommand Class:

    @Test
    public void simplePopCommandTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(111d);
        context.stackPush(222d);

        StackPop popCommand = new StackPop();
        popCommand.action(context, new String[] {"POP"});

        Assert.assertEquals(Double.valueOf(111d), context.stackPop());
    }

    @Test(expected = EmptyValStackException.class)
    public void emptyStackPopTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();

        StackPop popCommand = new StackPop();
        popCommand.action(context, new String[] {"POP"});

    }

}
