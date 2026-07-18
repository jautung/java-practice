enum LogLevel {
    TRACE,
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL,
    UNKNOWN,
    ;

    public String prefix() {
        switch (this) {
            case TRACE:
                return "[TRC]: ";
            case DEBUG:
                return "[DBG]: ";
            case INFO:
                return "[INF]: ";
            case WARNING:
                return "[WRN]: ";
            case ERROR:
                return "[ERR]: ";
            case FATAL:
                return "[FTL]: ";
            case UNKNOWN:
                return null;
            default:
                throw new IllegalArgumentException("Unknown log level: " + this);
        }
    }

    public int shortNumber() {
        switch (this) {
            case TRACE:
                return 1;
            case DEBUG:
                return 2;
            case INFO:
                return 4;
            case WARNING:
                return 5;
            case ERROR:
                return 6;
            case FATAL:
                return 42;
            case UNKNOWN:
                return 0;
            default:
                throw new IllegalArgumentException("Unknown log level: " + this);
        }
    }
}

public class LogLine {
    private final String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        for (LogLevel level: LogLevel.values()) {
            String prefix = level.prefix();
            if (prefix != null && logLine.startsWith(prefix)) {
                return level;
            }
        }
        return LogLevel.UNKNOWN;
    }

    public String getOutputForShortLog() {
        LogLevel level = getLogLevel();
        return "%d:%s".formatted(level.shortNumber(), logLine.substring(7));
    }
}
