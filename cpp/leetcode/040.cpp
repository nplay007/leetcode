class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        if(candidates.empty()) return {};
        vector<vector<int>> res;
        vector<int> ans;
        sort(candidates.begin(), candidates.end());
        help(0, target, candidates, ans, res);
        return res;
    }
    
    void help(int start, int target, vector<int>& candidates, vector<int>& ans, vector<vector<int>> &res){
        if(target == 0){
            res.push_back(ans);
            return;
        }
        for(int i = start; i < candidates.size() && candidates[i] <= target; i++){
            if(i > start && candidates[i] == candidates[i-1]) continue;
            ans.push_back(candidates[i]);
            help(i+1, target - candidates[i],candidates, ans, res);
            ans.pop_back();
        }
    }
};