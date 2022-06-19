package logger;

public class ConsoleLogger implements ILogger{
    @Override
    public void info(String string) {
        System.out.println("INFO: "+ string);
    }

    @Override
    public void error(String string, Exception exception) {
        System.out.println("ERROR: " + string + exception);
    }

    @Override
    public void warning(String string) {
        System.out.println("WARNING: " + string);
    }
}
