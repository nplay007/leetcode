class Solution {
public:
    int threeSumSmaller(vector<int>& nums, int target) {
        if(nums.size() < 3) return 0;
        sort(nums.begin(), nums.end());
        int cnts = 0;
        for(int i = 0; i < nums.size() - 2; i++){
            int l = i + 1, r = nums.size() - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] >= target) {
                    r--;
                } else {
                    cnts += r - l;
                    l++;
                }
            }
        }
        return cnts;
    }
};