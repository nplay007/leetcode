class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> ans;
        dfs(0, nums, ans, res);
        return res;
    }
    
    void dfs(int start, vector<int>& nums, vector<int>& ans, vector<vector<int>> &res){
        res.push_back(ans);
        for(int i = start; i < nums.size(); i++){
            ans.push_back(nums[i]);
            dfs(i+1, nums, ans, res);
            ans.pop_back();
        }
    }
};


class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int n = 1 << nums.size();
        vector<vector<int>> res(n, vector<int>());
        for(int j = 0; j < n; j++){
            for(int i = 0; i < nums.size(); i++){
                if((j >> i) & 1){
                    res[j].push_back(nums[i]);
                }
            }
        }
        return res;
    }
};