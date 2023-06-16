package operatorsTest;

import exceptions.*;
import operators.ExecutionContext;
import operators.Multiplication;
import org.junit.Assert;
import org.junit.Test;

public class MulTest {

    // tests for MulCommand Class:

    @Test
    public void simpleMulTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(4d);
        context.stackPush(2d);

        Multiplication mulCommand = new Multiplication();
        mulCommand.action(context, new String[] {"*"});

        Assert.assertEquals(Double.valueOf(4d * 2d), context.stackPeek());
    }

    @Test (expected = EmptyValStackException.class)
    public void notEnoughStackElementsMulTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(8.5d);

        Multiplication mulCommand = new Multiplication();
        mulCommand.action(context, new String[] {"*"});

    }

}
