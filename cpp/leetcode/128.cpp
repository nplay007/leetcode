class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> map(nums.begin(), nums.end());
        int res = 0;
        for(auto num : nums){
            if(map.find(num) == map.end()) continue;
            map.erase(num);
            int l = num - 1, r = num + 1;
            while(map.find(l) != map.end()) map.erase(l--);
            while(map.find(r) != map.end()) map.erase(r++);
            res = max(res, r - l - 1);
        }
        return res;
    }
};


class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int, int> map;
        int res = 0;
        for(int i = 0; i < nums.size(); i++){
            if(map.find(nums[i]) == map.end()){
                int l = map.find(nums[i] - 1) == map.end() ? 0 : map[nums[i] - 1];
                int r = map.find(nums[i] + 1) == map.end() ? 0 : map[nums[i] + 1];
                map[nums[i]] = l + r + 1;
                map[nums[i] - l] = l + r + 1;
                map[nums[i] + r] = l + r + 1;
                res = max(res, l +  r + 1);
            }
        }
        return res;
    }
};