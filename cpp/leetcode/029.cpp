class Solution {
public:
    int divide(int dividend, int divisor) {
        long long res = 0;
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long long dvd = labs(dividend), dvs = labs(divisor);
        while(dvd >= dvs){
            long long tmp = dvs;
            long long cnts = 1;
            while(dvd >= (tmp << 1)){
                tmp <<= 1;
                cnts <<= 1;
            }
            dvd -= tmp;
            res += cnts;
        }
        if(sign * res > INT_MAX || sign * res < INT_MIN) {
            return INT_MAX;
        }
        return sign * res;
    }
};