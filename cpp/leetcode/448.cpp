class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int> &nums) {
        vector<int> res;
        for (int num : nums) {
            int idx = abs(num) - 1;
            nums[idx] = -abs(nums[idx]);
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] > 0) {
                res.push_back(i + 1);
            }
        }
        return res;
    }
};