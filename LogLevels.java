public class LogLevels {
    static String[] LEVELS = {"INFO", "WARNING", "ERROR"};

    public static String message(String logLine) {
        ParsedLine parsedLine = parse(logLine);
        return parsedLine.message;
    }

    public static String logLevel(String logLine) {
        ParsedLine parsedLine = parse(logLine);
        return parsedLine.level.toLowerCase();
    }

    public static String reformat(String logLine) {
        ParsedLine parsedLine = parse(logLine);
        return "%s (%s)".formatted(parsedLine.message, parsedLine.level.toLowerCase());
    }

    static record ParsedLine(String level, String message) {}

    static ParsedLine parse(String logLine) {
        for (String level: LEVELS) {
            String prefix = "[%s]: ".formatted(level);
            if (logLine.startsWith(prefix)) {
                return new ParsedLine(level, logLine.substring(prefix.length()).trim());
            }
        }
        throw new Error("Log line '%s' cannot be parsed".formatted(logLine));
    }

    public static void main(String[] args) {
        System.out.println(LogLevels.message("[ERROR]: Invalid operation"));
        System.out.println(LogLevels.message("[WARNING]:  Disk almost full\r\n"));
        System.out.println(LogLevels.logLevel("[ERROR]: Invalid operation"));
        System.out.println(LogLevels.reformat("[INFO]: Operation completed"));
    }
}
