class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int major, counts = 0, n = nums.size();
        for (int i = 0; i < n; i++) {
            if (counts == 0) {
                major = nums[i];
                counts = 1;
            } else {
                counts += (nums[i] == major) ? 1 : -1;
            }
        }
        return major;
    }
};