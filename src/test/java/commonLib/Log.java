package commonLib;

import ch.qos.logback.classic.Logger;

public class Log {

    public static String logfile;

    static Logger log = null;

    public static void debug(String message, String exception) {
        log.debug(message, exception);
    }

    public static void info(String message) {
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void error(String message) {
        log.error(message);
    }

    public static void trace(String message) {
        log.trace(message);
    }

    
}
