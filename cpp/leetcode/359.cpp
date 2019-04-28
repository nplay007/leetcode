class Logger {
public:
    bool shouldPrintMessage(int timestamp, string message) {
        if (timestamp < log[message]) {
            return false;
        }
        log[message] = timestamp + 10;
        return true;
    }
private:
    unordered_map<string, int> log;
};