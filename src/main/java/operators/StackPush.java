package operators;

import org.apache.log4j.Logger;
import exceptions.CommandExecutionException;
import exceptions.EmptyMapException;

public class StackPush implements OperatorsFactory {

    private static final Logger logger = Logger.getLogger(StackPush.class);

    @Override
    public void action(ExecutionContext context, String[] args) throws CommandExecutionException {
        for (int i = 1; i < args.length; i++) {
            try {
                Double val = context.getVal(args[i]);
                context.stackPush(val);
            } catch (EmptyMapException e){
                try {
                    Double val = Double.valueOf(args[i]);
                    context.stackPush(val);
                } catch (NumberFormatException ex){
                    System.err.println("There is no value with this name: " + args[i]);
                    throw new CommandExecutionException("There is no value with this name: " + args[i]);
                }
            }
        }
    }
}
