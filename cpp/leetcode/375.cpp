class Solution {
public:
    int getMoneyAmount(int n) {
        vector<vector<int>> dp(n+1, vector<int>(n+1, 0));
        return help(dp, 1, n);
    }
    
    
    int help(vector<vector<int>> &dp, int s, int e){
        if(s >= e) return 0;
        if(dp[s][e] != 0) return dp[s][e];
        int res = INT_MAX;
        for(int i = s; i <= e; i++){
            int tmp = i + max(help(dp, s, i-1), help(dp, i+1, e));
            res = min(res, tmp);
        }
        dp[s][e] = res;
        return res;
    }
};