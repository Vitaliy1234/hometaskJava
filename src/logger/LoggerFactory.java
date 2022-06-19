package logger;

public class LoggerFactory {
    public static ILogger getLogger(){
        return new ConsoleLogger();
    }
}
