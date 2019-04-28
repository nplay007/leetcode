class Solution {
public:
int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        vector<int> dp(n + 1);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
};

class Solution {
public:
    int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int pre = 1, cur = 1;
        for (int i = 2; i <= n; i++) {
            cur = pre + cur;
            pre = cur - pre;
        }
        return cur;
    }
};