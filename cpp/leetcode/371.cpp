class Solution {
public:
    int getSum(int a, int b) {
        if (a == 0 || b == 0) return a == 0 ? b : a;
        int carry = 0;
        while(b){
            carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
};