class Solution {
public:
    vector<int> grayCode(int n) {
        n = 1 << n;
        vector<int> dp(n, 0);
        for(int i = 0; i < n; i++){
            dp[i] = i ^ (i >> 1);
        }
        return dp;
    }
};