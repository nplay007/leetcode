class Solution {
public:
    int maxProduct(vector<int> &nums) {
        if (nums.empty()) {
            return 0;
        }
        int pmin = nums[0], pmax = nums[0], res = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] < 0) {
                swap(pmin, pmax);
            }
            pmax = max(pmax * nums[i], nums[i]);
            pmin = min(pmin * nums[i], nums[i]);
            res = max(res, pmax);
        }
        return res;
    }
};