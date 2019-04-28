class Solution {
public:
    int maximumGap(vector<int>& nums) {
        if(nums.empty()) return 0;
        int pmax = INT_MIN, pmin = INT_MAX, n = nums.size();
        for(auto num : nums){
            pmax = max(num, pmax);
            pmin = min(num, pmin);
        }
        int width = (pmax - pmin) / n + 1;
        int size = (pmax - pmin) / width + 1;
        vector<int> dmax(size, INT_MIN), dmin(size, INT_MAX);
        unordered_set<int> s;
        for(auto num : nums){
            int idx = (num - pmin) / width;
            dmax[idx] = max(dmax[idx], num);
            dmin[idx] = min(dmin[idx], num);
            s.insert(idx);
        }
        int res = 0, pre = 0;
        for(int i = 1; i < size; i++){
            if(s.find(i) == s.end()) continue;
            res = max(res, dmin[i] - dmax[pre]);
            pre = i;
        }
        return res;
    }
};