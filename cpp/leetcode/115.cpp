class Solution {
public:
    int numDistinct(string s, string t) {
        int m = s.size(), n = t.size();
        vector<int> dp(n+1, 0);
        for(int i = 1; i <= m; ++i){
            int pre = 1;
            for(int j = 1; j <= n; ++j){
                int tmp = dp[j];
                if(s[i-1] == t[j-1]) dp[j] += pre;
                pre = tmp;
            }
        }
        return dp[n];
    }
};


class Solution {
public:
    int numDistinct(string s, string t) {
        int m = s.size(), n = t.size();
        vector<vector<int>> dp(m + 1, vector<int>(n+1, 0));
        for(int i = 0; i <= m; i++) dp[i][0] = 1;
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                dp[i][j] = dp[i-1][j];
                if(s[i-1] == t[j-1]) dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }
};