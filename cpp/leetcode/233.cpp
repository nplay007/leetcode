class Solution {
public:
    int countDigitOne(int n) {
        long m = 1;
        long res = 0;
        while(n >= m){
            long a = n / m, b = n % m;
            res += (a + 8) / 10 * m + (a % 10 == 1) * (b + 1); 
            m *= 10;
        }
        return res;
    }
};