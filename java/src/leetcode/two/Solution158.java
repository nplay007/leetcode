package JavaAnswer.two;

import JavaAnswer.Reader4;

public class Solution158 extends Reader4 {
    private char[] buffer = new char[4];
    int read = 0, write = 0;

    public int read(char[] buf, int n) {
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
}