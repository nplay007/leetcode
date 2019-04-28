class Solution {
public:
    int read(char *buf, int n) {
        for (int i = 0; i < n; ++i) {
            if (readPos == writePos) {
                writePos = read4(buff);
                readPos = 0;
                if (writePos == 0) return i;
            }
            buf[i] = buff[readPos++];
        }
        return n;
    }
private:
    int readPos = 0, writePos = 0;
    char buff[4];
};




class Solution {
public:
    int read(char *buf, int n) {
        int idx = 0;
        while(idx < n){
            if(writer < reader){
                buf[idx++] = buffer[writer++];
            } else {
                reader = read4(buffer);
                if(reader == 0) break;
                writer = 0;
            }
        }
        return min(idx, n);
    }
private:
    int writer = 0;
    int reader = 0;
    char buffer[4];
};