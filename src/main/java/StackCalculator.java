import operators.OperatorsFactory;
import operators.ExecutionContext;
import org.apache.log4j.Logger;
import exceptions.CommandExecutionException;
import exceptions.WrongInputException;
import exceptions.WrongCommandFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Properties;

public class StackCalculator {

    private static final String CONFIG_FILENAME = "operators.properties";
    private static final String SPLIT_SYMBOL = " ";
    private static final String COMMENT_SYMBOL = "#";
    private static final String END_OF_WORK_SYMBOL = "!";
    private static final Properties CONFIG = new Properties();

    private static final Logger logger = Logger.getLogger(StackCalculator.class);

    static {
        try {
            CONFIG.load(StackCalculator.class.getResourceAsStream(CONFIG_FILENAME));
        } catch (IOException err) {
            logger.error("Properties load error" + err);
            System.err.println("Properties load error.");
            throw new RuntimeException(err);
        }
    }
    public void calculations(BufferedReader in) throws IOException {
        ExecutionContext context = new ExecutionContext();
        String inputLine;
        boolean endFlag = false;
        while (((inputLine = in.readLine()) != null) && (!endFlag)){
            if (inputLine.startsWith(COMMENT_SYMBOL)) continue;
            if (inputLine.startsWith(END_OF_WORK_SYMBOL)) break;
            String[] args = inputLine.split(SPLIT_SYMBOL);
            try {
                OperatorsFactory command = commandFactory(args[0]);
                command.action(context, args);
            } catch (WrongCommandFormatException | CommandExecutionException err) {
                logger.error("Command execution error " + err);
                System.err.println("Command execution error. Wrong command format.");
            }
        }
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    private OperatorsFactory commandFactory(String commandName) throws WrongInputException {
        String className = CONFIG.getProperty(commandName);
        try {
            Class<OperatorsFactory> someClass = (Class<OperatorsFactory>) Class.forName(className);
            return someClass.newInstance();
        } catch (Exception err){
            logger.error("Wrong command " + commandName + " : " + err);
            System.err.println("Command execution error. Command " + commandName + " does not exist.");
            throw new WrongInputException("Wrong input " + commandName);
        }
    }
}
