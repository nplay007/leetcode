class Solution {
public:
    int findNthDigit(int n) {
        int len = 1, start = 1;
        long cnts = 9;
        
        while(n > len * cnts){
            n -= len * cnts;
            len ++;
            cnts *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        string s = to_string(start);
        return stoi(s.substr((n-1) % len, 1));
    }
};