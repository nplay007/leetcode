class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size() < 2) return nums.size();
        vector<int> data;
        for(int i = 0; i < nums.size(); i++){
            auto it = lower_bound(data.begin(), data.end(), nums[i]);
            if(it == data.end()) data.push_back(nums[i]);
            else *it = nums[i];
        }
        return data.size();
    }
};