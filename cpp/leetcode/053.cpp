class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if(nums.empty()) {
            return 0;
        }
        int maxSum = nums[0], curMax = nums[0];
        for(int i = 1; i < nums.size(); ++i){
            curMax = max(nums[i], nums[i] + curMax);
            maxSum = max(maxSum, curMax);
        }
        return maxSum;
    }
};