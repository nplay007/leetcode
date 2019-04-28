class Solution {
public:
    int maxCoins(vector<int>& nums) {
        nums.insert(nums.begin(), 1);
        nums.push_back(1);
        int n = nums.size();
        vector<vector<int> > dp(n, vector<int>(n , 0));
        for (int span = 2; span < n; ++span) {
            for (int l = 0; l < n - span; ++l) {
                int r = l + span;
                for (int m = l + 1; m < r; ++m) {
                    dp[l][r] = max(dp[l][r], nums[l] * nums[m] * nums[r] + dp[l][m] + dp[m][r]);
                }
            }
        }
        return dp[0][n-1];
    }
};