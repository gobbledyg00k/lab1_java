package operatorsTest;

import exceptions.*;
import operators.Division;
import operators.ExecutionContext;
import org.junit.Assert;
import org.junit.Test;

public class DivTest {
    // tests for DivCommand Class:

    @Test
    public void simpleDivTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(4d);
        context.stackPush(2d);

        Division divCommand = new Division();
        divCommand.action(context, new String[] {"/"});

        Assert.assertEquals(Double.valueOf(4d/2d), context.stackPeek());
    }

    @Test (expected = EmptyValStackException.class)
    public void notEnoughStackElementsDivTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(8.4d);

        Division divCommand = new Division();
        divCommand.action(context, new String[] {"/"});

    }

    @Test (expected = DivByZeroException.class)
    public void divByZeroTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(8.4d);
        context.stackPush(0d);

        Division divCommand = new Division();
        divCommand.action(context, new String[] {"/"});

    }

}
