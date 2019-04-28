class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        int m = primes.size();
        vector<int> index(m, 0);
        vector<int> dp(n, INT_MAX);
        dp[0] = 1; // skip 1
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i] = min(dp[i], dp[index[j]] * primes[j]);
            }
            for(int j = 0; j < m; j++){
                if(dp[i] == dp[index[j]] * primes[j]) index[j]++;
            }
        }
        return dp[n-1];
    }
};