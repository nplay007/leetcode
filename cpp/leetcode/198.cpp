class Solution {
public:
    int rob(vector<int> &num) {
        int n = num.size();
        if (n == 0) {
            return 0;
        }
        vector<int> dp(n + 1, 0);
        dp[1] = num[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = max(dp[i - 1], dp[i - 2] + num[i - 1]);
        }
        return dp[n];
    }
};

class Solution {
public:
    int rob(vector<int> &nums) {
        int cur = 0, pre = 0;
        for (int i = 0; i < nums.size(); i++) {
            int tmp = cur;
            cur = max(pre + nums[i], cur);
            pre = tmp;
        }
        return cur;
    }
};