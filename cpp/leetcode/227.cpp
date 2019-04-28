class Solution {
public:
    int calculate(string s) {
        int res = 0, num = 0;
        char sign = '+';
        stack<int> stk;
        for (int i = 0; i < s.size(); ++i) {
            if (isdigit(s[i])) num = num * 10 + s[i] - '0';
            if ((!isdigit(s[i]) && s[i] != ' ') || i == s.size() - 1) {
                if (sign == '+') stk.push(num);
                else if (sign == '-') stk.push(-num);
                else  {
                    int tmp = sign == '*' ? stk.top() * num : stk.top() / num;
                    stk.pop();
                    stk.push(tmp);
                }
                sign = s[i];
                num = 0;
            } 
        }
        while (!stk.empty()) {
            res += stk.top();
            stk.pop();
        }
        return res;
    }
};