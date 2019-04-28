class Solution {
public:
    int numDecodings(string s) {
        if(s.empty()) {
            return 0;
        }
        int n = s.size();
        int pre = 1, cur = 1;
        for(int i = 1; i <= n; ++i){
            if(s[i-1] < '1' || s[i-1] > '9') {
                cur = 0;
            }
            if(i >= 2 && (s[i - 2] == '1' || (s[i-2] == '2' && s[i-1] < '7'))) {
                cur = pre + cur;
                pre = cur - pre;
            } else {
                pre = cur;
            }
        }
        return cur;
    }
};

class Solution {
public:
    int numDecodings(string s) {
        if(s.empty()) {
            return 0;
        }
        int n = s.size();
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        for(int i = 1; i <= n; ++i){
            if('0' < s[i-1] && s[i-1] <= '9') {
                dp[i] = dp[i-1];
            }
            if(i >= 2 && (s[i - 2] == '1' || (s[i-2] == '2' && s[i-1] < '7'))) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
};