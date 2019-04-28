class Solution {
public:
    int countPrimes(int n) {
        vector<bool> prime(n, false);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    prime[i * j] = true;
                }
            }
        }
        return count;
    }
};