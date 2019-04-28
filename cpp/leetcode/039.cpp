class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
     sort(candidates.begin(), candidates.end());
     vector<vector<int>> res;
     vector<int> ans;
     help(0, target, candidates, ans, res);
     return res;
    }
    
    void help(int start, int target, vector<int> &candidates, vector<int> &ans, vector<vector<int>> &res){
        if(target == 0){
            res.push_back(ans);
            return;
        }
        for(int i = start; i < candidates.size() && target >= candidates[i]; i++){
            ans.push_back(candidates[i]);
            help(i, target - candidates[i], candidates, ans, res); // it's i
            ans.pop_back();
        }
    }
};