package operatorsTest;

import exceptions.*;
import operators.ExecutionContext;
import operators.StackPush;
import org.junit.Assert;
import org.junit.Test;

public class PushTest {
    // tests for PushCommand Class:
    @Test
    public void testPushCommand() throws CommandExecutionException {
        ExecutionContext context = new ExecutionContext();

        StackPush pushCommand = new StackPush();
        pushCommand.action(context, new String[] {"PUSH", "111"});

        Double value = context.stackPop();
        Assert.assertEquals(Double.valueOf(111d), value);
    }

    @Test
    public void testPushWithVariable() throws CommandExecutionException {
        Double source = 111d;

        ExecutionContext context = new ExecutionContext();
        context.putVal("x", source);

        StackPush pushCommand = new StackPush();
        pushCommand.action(context, new String[] {"PUSH", "x"});

        Double result = context.stackPop();
        Assert.assertEquals(source, result);
    }

    @Test(expected = CommandExecutionException.class)
    public void testPushWithMissingVariable() throws CommandExecutionException {
        Double source = 123d;

        ExecutionContext context = new ExecutionContext();
        context.putVal("x", source);

        StackPush pushCommand = new StackPush();
        pushCommand.action(context, new String[] {"PUSH", "y"});

    }
}
