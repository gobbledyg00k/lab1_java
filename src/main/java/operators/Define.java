package operators;

import exceptions.ArgsNumberException;
import exceptions.WrongArgTypeException;
import exceptions.WrongCommandFormatException;

import org.apache.log4j.Logger;

public class Define implements OperatorsFactory {
    public static final int TWO = 2;

    private final Logger logger = Logger.getLogger(Define.class);
    @Override
    public void action(ExecutionContext context, String[] args) throws WrongCommandFormatException {
        try{
            context.putVal(args[1], Double.valueOf(args[TWO]));
        } catch (NumberFormatException e){
            logger.trace("Wrong argument format. " + args[TWO] + "is not a number." + e);
            System.err.println("Wrong argument format. " + args[TWO] + "is not a number.");
            throw new WrongArgTypeException("Wrong argument format. " + args[TWO] + "is not a number.");
        } catch (Exception e){
            logger.warn("Wrong count of arguments after command DEFINE. " + e);
            System.err.println("Wrong count of arguments after command DEFINE.");
            throw new ArgsNumberException("Wrong count of arguments after command DEFINE: it's " + (args.length-1) + "but it's must be 2.");
        }
    }
}
