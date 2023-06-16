import org.apache.log4j.Logger;

import java.io.*;

public class Main {

    public static final int ONE = 1;
    public static final int ZERO = 0;
    private static final Logger logger = Logger.getLogger(StackCalculator.class);
    public static void main(String[] args) throws Exception {
        if(args.length > ONE){
            logger.error("Too much program arguments");
            System.err.println("Too much program arguments.");
            return;
        }
        InputStream source;
        if(args.length > ZERO){
            logger.info("Work with input file");
            source = new FileInputStream(args[0]);
        } else {
            logger.info("Work with stdin");
            source = System.in;
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(source));
        try{
            StackCalculator calc = new StackCalculator();
            calc.calculations(in);
        } catch (Exception e){
            System.exit(0);
        }
    }
}
