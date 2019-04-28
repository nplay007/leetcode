class Solution {
public:
    int maxProfit(int k, vector<int> &prices) {
        int n = prices.size();
        if (n < 2) return 0;
        if (k > n/2){ 
            int ans = 0;
            for (int i = 1; i < n; ++i) ans += max(prices[i] - prices[i-1], 0);
            return ans;
        }
        vector<int> hold(k + 1, INT_MIN), uhold(k + 1, 0);
        for (int i = 0; i < n; ++i){
            int cur = prices[i];
            for(int j = k; j > 0; --j){
                uhold[j] = max(uhold[j], hold[j] + cur);
                hold[j] = max(hold[j], uhold[j-1] - cur);
            }
        }
        return uhold[k];
    }
};



class Solution {
public:
    int maxProfit(int k, vector<int> &prices) {
        int n = prices.size();
        if (n < 2) return 0;
        if (k > n/2){ 
            int ans = 0;
            for (int i = 1; i < n; ++i) ans += max(prices[i] - prices[i-1], 0);
            return ans;
        }
        vector<vector<int>> hold(k + 1, vector<int>(n, 0)), uhold(k + 1, vector<int>(n, 0));
        for (int i = 1; i <= k; ++i){
            hold[i][0] = -prices[0];
            uhold[i][0] = 0;
            for(int j = 1; j < n; ++j){
                hold[i][j] = max(hold[i][j-1], uhold[i-1][j] - prices[j]);
                uhold[i][j] = max(uhold[i][j-1], hold[i][j-1] + prices[j]);
            }
        }
        return uhold[k][n-1];
    }
};