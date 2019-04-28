class Solution {
public:
    int maxSubArrayLen(vector<int> &nums, int k) {
        if (nums.empty()) {
            return 0;
        }
        int sum = 0, res = 0;
        unordered_map<int, int> m{{0, -1}};
        for (int i = 0; i < nums.size(); ++i) {
            sum += nums[i];
            if (sum == k) {
                res = i + 1;
            }
            else if (m.count(sum - k)) {
                res = max(res, i - m[sum - k]);
            }
            if (!m.count(sum)) {
                m[sum] = i;
            }
        }
        return res;
    }
};