class Solution {
public:
    int read(char *buf, int n) {
        int idx = 0;
        while(idx < n){
            int size = read4(buf + idx);
            idx += size;
            if(size < 4) break;
        }
        return min(idx, n);
    }
};