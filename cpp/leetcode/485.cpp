class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        if(nums.empty()) return 0;
        int n = nums.size();
        vector<int> dp(n+1, 0);
        int res = 0;
        for(int i = 1; i <= n; i++){
            if(nums[i-1] == 1) dp[i] = 1 + dp[i-1];
            res = max(res, dp[i]);
        }
        return res;
    }
};



class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        if(nums.empty()) return 0;
        int n = nums.size();
        int cur = 0, res = 0;
        for(int i = 1; i <= n; i++){
            cur = nums[i-1] == 1 ? cur + 1 : 0;
            res = max(res, cur);
        }
        return res;
    }
};