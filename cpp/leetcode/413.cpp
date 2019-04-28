class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        int n = A.size();
        if (n < 3) return 0;
        vector<int> dp(n, 0); // dp[i] means the number of arithmetic slices ending with A[i]
        if (A[2] - A[1] == A[1] - A[0]) dp[2] = 1; 
        int res = dp[2];
        for (int i = 3; i < n; ++i) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) 
                dp[i] = dp[i-1] + 1;
            res += dp[i]; 
        }
        return res;
    }
};