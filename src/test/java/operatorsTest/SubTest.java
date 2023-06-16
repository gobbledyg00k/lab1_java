package operatorsTest;

import exceptions.*;
import operators.ExecutionContext;
import operators.Subtraction;
import org.junit.Assert;
import org.junit.Test;

public class SubTest {

    // tests for SubCommand Class:

    @Test
    public void simpleSubTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(4d);
        context.stackPush(1d);

        Subtraction subCommand = new Subtraction();
        subCommand.action(context, new String[] {"-"});

        Assert.assertEquals(Double.valueOf(4d - 1d), context.stackPeek());
    }

    @Test (expected = EmptyValStackException.class)
    public void notEnoughStackElementsSubTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(8d);

        Subtraction subCommand = new Subtraction();
        subCommand.action(context, new String[] {"-"});

    }

}
