class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n < 2) return n ? nums[0] : 0;
        return max(help(nums, 0, nums.size()-1), help(nums, 1, nums.size()));
    }
    
    int help(vector<int> &nums, int start, int end){
        int pre = 0, cur = 0;
        for(int i = start; i < end; i++){
            int tmp = cur;
            cur = max(cur, pre + nums[i]);
            pre = tmp;
        }
        return cur;
    }
};