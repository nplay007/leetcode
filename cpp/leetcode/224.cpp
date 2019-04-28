class Solution {
public:
    int calculate(string s) {
        int res = 0;
        vector<int> sign(2, 1);
        for (int i = 0; i < s.size(); ++i) {
            char c = s[i];
            if (c >= '0') {
                int num = 0;
                while (i < s.size() && s[i] >= '0') {
                    num = 10 * num + s[i++] - '0';
                }
                res += sign.back() * num;
                sign.pop_back();
                --i;
            }
            else if (c == ')') sign.pop_back();
            else if (c != ' ') sign.push_back(sign.back() * (c == '-' ? -1 : 1));
        }
        return res;
    }
};


class Solution {
public:
    int calculate(string s) {
        stack<int> stk;
        int res = 0, num = 0, sign = 1;
        for(int i = 0; i < s.size(); i++){
            char ch = s[i];
            if(isdigit(ch)){
                num = num * 10 + ch - '0';
            } else if(ch == '+'){
                res += sign * num;
                num = 0;
                sign = 1;
            } else if(ch == '-'){
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (ch == '('){
                stk.push(res);
                stk.push(sign);
                sign = 1;
                res = 0;
            } else if (ch == ')'){
                res += sign * num;
                num = 0;
                res *= stk.top(); stk.pop();  // sign
                res += stk.top(); stk.pop(); // number
            }
        }
        if(num != 0) res += sign * num;
        return res;
    }
};