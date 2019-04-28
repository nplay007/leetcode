class Solution {
  public:
    vector<int> twoSum(vector<int> &nums, int target) {
        if (nums.size() < 2) {
            throw invalid_argument("Invalid nums");
        }
        vector<int> res;
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                res.push_back(l + 1);
                res.push_back(r + 1);
                return res;
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        throw invalid_argument("Can't find solution");
    }
};