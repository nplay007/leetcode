class Solution {
public:
    string addBinary(string a, string b) {
        int m = a.size() - 1, n = b.size() - 1;
        int carry = 0;
        string res = "";
        while (m >= 0 || n >= 0 || carry) {
            int x = (m >= 0) ? a[m--] - '0' : 0;
            int y = (n >= 0) ? b[n--] - '0' : 0;
            res = char((x + y + carry) % 2 + '0') + res;
            carry = (x + y + carry) / 2;
        }
        return res;
    }
};