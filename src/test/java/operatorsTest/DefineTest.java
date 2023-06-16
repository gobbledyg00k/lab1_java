package operatorsTest;

import exceptions.*;
import operators.Define;
import operators.ExecutionContext;
import org.junit.Assert;
import org.junit.Test;

public class DefineTest {
    // tests for DefineCommand Class:

    @Test
    public void simpleDefineTest() throws WrongCommandFormatException, EmptyMapException {

        ExecutionContext context = new ExecutionContext();

        Define defineCommand = new Define();
        defineCommand.action(context, new String[] {"DEFINE", "const", "123"});

        Assert.assertEquals(Double.valueOf(123d), context.getVal("const"));
    }

    @Test(expected = WrongArgTypeException.class)
    public void wrongValueDefineTest() throws WrongCommandFormatException {

        ExecutionContext context = new ExecutionContext();

        Define defineCommand = new Define();
        defineCommand.action(context, new String[] {"DEFINE", "const", "qwerty"});

    }

    @Test(expected = ArgsNumberException.class)
    public void wrongArgNumDefineTest() throws WrongCommandFormatException {

        ExecutionContext context = new ExecutionContext();

        Define defineCommand = new Define();
        defineCommand.action(context, new String[] {"DEFINE", "const"});

    }


}
