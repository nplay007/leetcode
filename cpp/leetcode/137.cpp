public class Solution {
    int singleNumber(vector<int> &nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}

public class Solution {
    int singleNumber(vector<int> &nums) {
        int count[32] = {0};
        int result = 0, n = nums.size();
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < n; j++) {
                if ((nums[j] >> i) & 1) count[i]++;
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }
}