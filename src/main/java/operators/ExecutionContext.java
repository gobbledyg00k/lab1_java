package operators;

import org.apache.log4j.Logger;
import exceptions.EmptyValStackException;
import exceptions.EmptyMapException;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionContext {
    private final Stack <Double> stack;
    private final Map <String , Double> defines;

    private final Logger logger = Logger.getLogger(ExecutionContext.class);

    public ExecutionContext(){
        defines = new HashMap<>();
        stack = new Stack<>();
    }

    public Double getVal(String name) throws EmptyMapException {
        try {
            Double x = defines.get(name);
            if (x == null){
                throw new NullPointerException();
            }
            return x;
        } catch (NullPointerException e) {
            logger.trace("Define " + name + " does not exist.");
            throw new EmptyMapException("Define " + name + " does not exist.");
        }
    }

    public void putVal(String name, Double value){
        defines.put(name, value);
    }

    public void stackPush(Double value){
        stack.push(value);
    }

    public Double stackPop() throws EmptyValStackException {
        try {
            return stack.pop();
        } catch (EmptyStackException e) {
            System.err.println("Unable to get value from stack. Stack is empty.");
            logger.trace("Unable to get value from stack. Stack is empty.");
            throw new EmptyValStackException("Unable to get value from stack. Stack is empty.");
        }
    }

    public Double stackPeek() throws EmptyValStackException {
        try {
            return stack.peek();
        } catch (EmptyStackException e) {
            System.err.println("Unable to get value from stack. Stack is empty.");
            logger.trace("Unable to get value from stack. Stack is empty.");
            throw new EmptyValStackException("Unable to get value from stack. Stack is empty.");
        }
    }
}
