class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if (nums.empty()) {
            return 0;
        }
        int j = 0;
        for (int num : nums) {
            if (val != num) {
                nums[j++] = num;
            }
        }
        return j;
    }
};