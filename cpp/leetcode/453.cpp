class Solution {
public:
    int minMoves(vector<int> &nums) {
        int n = nums.size();
        if (n <= 1) {
            return 0;
        }
        int minNum = nums[0];
        long sum = nums[0];
        for (int i = 1; i < n; ++i) {
            minNum = min(minNum, nums[i]);
            sum += nums[i];
        }
        return sum - long(minNum) * long(n);
    }
};