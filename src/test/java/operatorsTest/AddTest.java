package operatorsTest;

import exceptions.*;
import operators.ExecutionContext;
import operators.Addition;
import org.junit.Assert;
import org.junit.Test;

public class AddTest {
    // tests for SumCommand Class:

    @Test
    public void simpleSumTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(4d);
        context.stackPush(2d);

        Addition sumCommand = new Addition();
        sumCommand.action(context, new String[] {"+"});

        Assert.assertEquals(Double.valueOf(4d + 2d), context.stackPeek());
    }

    @Test (expected = EmptyValStackException.class)
    public void notEnoughStackElementsSumTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(8d);

        Addition sumCommand = new Addition();
        sumCommand.action(context, new String[] {"+"});

    }

}
