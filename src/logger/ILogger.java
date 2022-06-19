package logger;

public interface ILogger {
    void info(String string);

    void error(String string, Exception exception);

    void warning(String string);
}
