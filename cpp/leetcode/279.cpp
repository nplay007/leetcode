class Solution {
public:
    int numSquares(int n) {
        vector<int> dp(n + 1, 0);
        for(int i = 0; i <= n; i++) dp[i] = i;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j *j <= i; j++){
                dp[i] = min(dp[i], dp[i - j *j]+1);
            }
        }
        return dp[n];
    }
};