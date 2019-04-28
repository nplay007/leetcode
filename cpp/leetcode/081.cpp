class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int l = 0, r = nums.size() - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(target == nums[m]) return true;
            if(nums[m] > nums[l]) {
                if(nums[l] <= target && target < nums[m]) r = m - 1;
                else l = m + 1;
            } else if(nums[m] < nums[l]) {
                if(nums[r] >= target && target > nums[m]) l = m + 1;
                else r = m - 1;
            } else {
                l ++;
            }
        }
        return false;
    }
};