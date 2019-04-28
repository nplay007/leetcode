class Solution {
public:
    vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
        long long left = (long long) lower - 1;
        vector<long long> data;
        for(auto num : nums) data.push_back(num);
        data.push_back((long long) upper + 1);
        vector<string> res;
        for(long long num : data){
            if(num == left + 2){
                res.push_back(to_string(num - 1));
            } else if (num > left + 2){
                res.push_back(to_string(left + 1) + "->" + to_string(num - 1));
            }
            left = num;
        }
        return res;
    }
};