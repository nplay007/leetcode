class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0), target = sum >> 1;
        if (sum & 1) return false;
        vector<int> dp(target + 1, 0);
        dp[0] = 1;
        for(auto num : nums) 
            for(int i = target; i >= num; i--)
                dp[i] = dp[i] || dp[i - num];
        return dp[target];
    }
};


bool canPartition(vector<int>& nums) {
    bitset<5001> bits(1);
    int sum = accumulate(nums.begin(), nums.end(), 0);
    for (auto n : nums) bits |= bits << n;
    return !(sum & 1) && bits[sum >> 1];
}