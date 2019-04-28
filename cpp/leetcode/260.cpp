class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int res = 0;
        for(auto num : nums) res ^= num;
        int maker = 1;
        while(!(res & maker)) {
            maker <<= 1;
        }
        int x = 0;
        for(auto num : nums){
            if(num & maker) x ^= num;
        }
        return {x, res ^ x};
    }
};