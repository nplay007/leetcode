class Solution {
public:
    vector<vector<int> > subsetsWithDup(vector<int> &nums) {
		sort(nums.begin(), nums.end());
        vector<vector<int> > res;
		vector<int> ans;
		dfs(res, nums, ans, 0);
		return res;
    }
private:
	void dfs(vector<vector<int>> &res, vector<int> &nums, vector<int> &ans, int start) {
		res.push_back(ans);
		for (int i = start; i < nums.size(); ++i){
			if (i == start || nums[i] != nums[i - 1]) { 
				ans.push_back(nums[i]);
				dfs(res, nums, ans, i + 1);
				ans.pop_back();
			}
		}
	}
};

vector<vector<int> > subsetsWithDup(vector<int> &nums) {
    sort(nums.begin(), nums.end());
    vector<vector<int>> res;
    int size = 0, start = 0;
    for (int i = 0; i < nums.size(); i++) {
        start = i >= 1 && nums[i] == nums[i - 1] ? size : 0;
        size = res.size();
        for (int j = start; j < size; j++) {
            vector<int> tmp = res[j];
            tmp.push_back(nums[i]);
            res.push_back(tmp);
        }
    }
    return res;
}