package operators;

import exceptions.CommandExecutionException;
import exceptions.SQRTException;

public class SQRT implements OperatorsFactory {
    @Override
    public void action(ExecutionContext context, String[] args) throws CommandExecutionException {
        Double a = context.stackPop();
        if (a < 0){
            System.err.println("Wrong argument for SQRT:" + a);
            throw new SQRTException("Wrong argument for SQRT:" + a);
        }
        context.stackPush(Math.sqrt(a));
    }
}
