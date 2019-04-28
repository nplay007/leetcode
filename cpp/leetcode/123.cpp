class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int dp[2][4] = {INT_MIN, 0, INT_MIN, 0}; 
        // 0: 1 buy, 1: one buy/sell, 2: 2 buys/1 sell, 3, 2 buys/sells
        int len = prices.size(), i, cur = 0, next =1;
        for(i=0; i<len; ++i) {
            dp[next][0] = max(dp[cur][0], -prices[i]);
            dp[next][1] = max(dp[cur][1], dp[cur][0]+prices[i]);
            dp[next][2] = max(dp[cur][2], dp[cur][1]-prices[i]);
            dp[next][3] = max(dp[cur][3], dp[cur][2]+prices[i]);
            swap(next, cur);
        }
        return max(dp[cur][1], dp[cur][3]);
    }
};