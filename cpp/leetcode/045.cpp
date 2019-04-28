class Solution {
public:
    int jump(vector<int>& nums) {
        int step = 0, reach = 0, cur = 0;
        for(int i = 0; i < nums.size(); i++){
            if (i > reach){
                step ++;
                reach = cur;  // max distance by step
            }
            cur = max(cur, nums[i] + i); // max distance by step + 1
        }
        return step;
    }
};