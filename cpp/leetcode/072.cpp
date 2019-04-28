class Solution {
public:
    int minDistance(string word1, string word2) {
        int m = word1.size(), n = word2.size();
        vector<int> dp(n+1, 0);
        for(int i = 1; i <= n; ++i) dp[i] = i;
        for(int i = 1; i <= m; i++){
            int pre = dp[0]; // dp[i-1][0] 
            dp[0] = i; // dp[i][0] = i
            for(int j = 1; j <= n; j++){
                int tmp = dp[j];
                if(word1[i-1] == word2[j-1]) dp[j] = pre;
                else dp[j] = 1 + min(dp[j], min(dp[j-1], pre));
                pre = tmp;
            }
        }
        return dp[n];
    }
};


class Solution {
public:
    int minDistance(string word1, string word2) {
        int m = word1.size(), n = word2.size();
        vector<vector<int>> dp(m + 1, vector<int>(n+1, 0));
        for(int i = 1; i <= m; i++) dp[i][0] = i;
        for(int i = 1; i <= n; ++i) dp[0][i] = i;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1[i-1] == word2[j-1]) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[m][n];
    }
};