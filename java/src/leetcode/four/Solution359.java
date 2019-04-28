package JavaAnswer.four;

import java.util.HashMap;
import java.util.Map;

class Logger {
    private Map<String, Integer> log;

    Logger() {
        log = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < log.getOrDefault(message, -1)) {
            return false;
        }
        log.put(message, timestamp + 10);
        return true;
    }
}
