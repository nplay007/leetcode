class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        if (A.empty()) return 0;
        int n = A.size();
        vector<unordered_map<long long, int >> dp(n);
        unordered_set<int> s(A.begin(), A.end());
        int res = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = i-1; j >= 0; --j) {
                long long d = (long long)A[i] - (long long)A[j];
                int tmp = dp[j].count(d) ? dp[j][d] : 0;
                if (tmp) res += tmp;
                if (s.count(A[i]+d)) dp[i][d] += 1 + tmp;
            }
        }
        return res;
    }
};