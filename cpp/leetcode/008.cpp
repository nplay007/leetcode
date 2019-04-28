class Solution {
public:
    int myAtoi(string str) {
        if (str.size() == 0) {
            return 0;
        }
        int sign = 1, i = 0;
        long long res = 0;
        for (; i < str.size() && str[i] == ' '; i++);
        if (str[i] == '+' || str[i] == '-') {
            sign = str[i++] == '+' ? 1 : -1
        }
        while (i < str.size()) {
            if (str[i] >= '0' && str[i] <= '9') {
                res = 10 * res + str[i++] - '0';
            } else {
                break;
            }
            if (res * sign > INT_MAX) {
                return INT_MAX;
            } else if (res * sign < INT_MIN) {
                return INT_MIN;
            }

        }
        return (int) res * sign;
    }
};