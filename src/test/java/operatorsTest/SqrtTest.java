package operatorsTest;

import exceptions.CommandExecutionException;
import exceptions.EmptyValStackException;
import exceptions.SQRTException;
import operators.ExecutionContext;
import operators.SQRT;
import org.junit.Assert;
import org.junit.Test;

public class SqrtTest {
    // tests for SQRTCommand Class:
    @Test
    public void simpleSQRTTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(16d);

        SQRT SQRTCommand = new SQRT();
        SQRTCommand.action(context, new String[] {"SQRT"});

        Assert.assertEquals(Double.valueOf(Math.sqrt(16d)), context.stackPeek());
    }

    @Test (expected = EmptyValStackException.class)
    public void notEnoughStackElementsSQRTTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();

        SQRT SQRTCommand = new SQRT();
        SQRTCommand.action(context, new String[] {"SQRT"});

    }

    @Test (expected = SQRTException.class)
    public void wrongValSQRTTest() throws CommandExecutionException {

        ExecutionContext context = new ExecutionContext();
        context.stackPush(-4d);

        SQRT SQRTCommand = new SQRT();
        SQRTCommand.action(context, new String[] {"SQRT"});

    }


}
