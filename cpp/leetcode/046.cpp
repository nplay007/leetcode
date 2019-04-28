class Solution {
public:
    vector<vector<int>> permute(vector<int> &num) {
        vector<vector<int>> result;
        permuteRecursive(nums, 0, result);
        return result;
    }

    void permuteRecursive(vint start, vector<int> &nums, vector<vector<int> > &result) {
        if (start >= nums.size()) {
            result.push_back(nums);
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            swap(nums[start], nums[i]);
            permuteRecursive(nums, start + 1, result);
            swap(nums[start], nums[i]); // reset
        }
    }
};



class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        vector<vector<int>> buffer;
        res.push_back(vector<int>());
        for(int i = 0; i < nums.size(); ++i){
            for(int j = 0; j < res.size(); ++j){
                for(int k = 0; k <= res[j].size(); ++k){
                    vector<int> tmp(res[j]);
                    tmp.insert(tmp.begin() + k, nums[i]);
                    buffer.push_back(tmp);
                }
            }
            res = buffer;
            buffer.clear();
        }
        return res;
    }
};
