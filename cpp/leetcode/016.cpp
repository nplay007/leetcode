class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        if (nums.size() < 3) {
            throw new invalid_argument("invalid argument");
        }
        sort(nums.begin(), nums.end());
        int absThreeSum = INT_MAX;
        int minThreeSum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            int left = i + 1, right = nums.size() - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (abs(threeSum - target) < absThreeSum) {
                    absThreeSum = abs(threeSum - target);
                    minThreeSum = threeSum;
                }
                if (threeSum == target) {
                    return threeSum;
                } else if (threeSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return minThreeSum;
    }
};