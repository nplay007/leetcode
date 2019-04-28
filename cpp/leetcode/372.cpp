class Solution {
public:
    int superPow(int a, vector<int>& b) {
        long long res = 1;
        for (int digit : b) {
            res = pow(res, 10) * pow(a, digit) % 1337;
        }
        return res;
    }
    int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        else if (n == 1) {
            return x % 1337;
        }
        return pow(x % 1337, n / 2) * pow(x % 1337, n - n / 2) % 1337;
    }
};