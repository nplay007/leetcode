int combinationSum4(vector<int>& nums, int target) {
    vector<int> res(target + 1);
    res[0] = 1;
    for (int i = 1; i <= target; ++i) {
        for (int x : nums) {
            if (i >= x) res[i] += res[i - x];
        }
    }
    return res[target];
}
