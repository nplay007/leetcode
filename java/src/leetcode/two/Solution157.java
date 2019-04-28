package JavaAnswer.two;

public class Solution157 {
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int write = 0, read = 0;
        for (int i = 0; i < n; i++) {
            if (read == write) {
                write = read4(buffer);
                read = 0;
            }
            if (write == 0) {
                return i;
            }
            buf[i] = buffer[read++];
        }
        return n;
    }

    private int read4(char[] tmp) {
        return 0;
    }
}

class Solution157II {
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int idx = 0;
        while (n > idx) {
            int size = read4(buffer);
            int sizeToRead = Math.min(size, n - idx);
            for (int i = 0; i < sizeToRead; i++) {
                buf[idx++] = buffer[i];
            }
            if (size < 4) {
                return idx;
            }
        }
        return idx;
    }

    private int read4(char[] tmp) {
        return 0;
    }
}