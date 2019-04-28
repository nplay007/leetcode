class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        if(nums.empty()) return 0;
        int res = 0, len = INT_MAX;
        int start = 0;
        for(int i = 0; i < nums.size(); i++){
            res += nums[i];
            while(res >= s){
                len = min(len, i - start + 1);
                res -= nums[start++];
            }
        }
        return len == INT_MAX? 0 : len;
    }
};

// O(nlgn)
class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int n = nums.size(), sums[n + 1] = {0}, res = n + 1;
        for (int i = 1; i < n + 1; ++i) sums[i] = sums[i - 1] + nums[i - 1];
        for (int i = 0; i < n + 1; ++i) {
            int right = searchRight(i + 1, n, sums[i] + s, sums);
            if (right == n + 1) break;
            if (res > right - i) res = right - i;
        }
        return res == n + 1 ? 0 : res;
    }
    
    int searchRight(int left, int right, int key, int sums[]) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sums[mid] >= key) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
};