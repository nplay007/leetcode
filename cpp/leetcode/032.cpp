class Solution {
public:
    int longestValidParentheses(string s) {
        int res = 0, n = s.size();
        vector<int> dp(n+1, 0);
        for(int i = 1; i <= n; i++){
            int j = i - 2 - dp[i-1];
            if(s[i-1] == '(' || j < 0 || s[j] == ')') dp[i] = 0;
            else{
                dp[i] = dp[i-1] + 2 + dp[j];
                res = max(res, dp[i]);
            }
        }
        return res;
    }
};



class Solution {
public:
    int longestValidParentheses(string s) {
        int res = 0, last = -1;
        stack<int> stk;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                stk.push(i);
            } else {
                if (stk.empty()) {
                    last = i;
                } else {
                    stk.pop();
                    res = stk.empty()? max(res, i - last) : max(res, i - stk.top());
                }
            }
        }
        return res;
    }
};