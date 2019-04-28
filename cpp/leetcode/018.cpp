class Solution {
  public:
    vector<vector<int>> fourSum(vector<int> &nums, int target) {
        vector<vector<int>> res;
        if (nums.size() < 4) {
            return res;
        }
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.size() - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = nums.size() - 1;
                while (l < r) {
                    if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                        res.push_back({nums[i], nums[j], nums[l], nums[r]});
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                    else if (nums[i] + nums[j] + nums[l] + nums[r] > target) {
                        r--;
                    }
                    else {
                        l++;
                    }
                }
            }
        }
        return res;
    }
};

class Solution {
  public:
    vector<vector<int>> fourSum(vector<int> &nums, int target) {
        set<vector<int>> res;
        if (nums.size() < 4) {
            return {};
        }
        sort(nums.begin(), nums.end());
        unordered_map<int, vector<pair<int, int>>> map;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int key = nums[i] + nums[j];
                map[key].push_back(make_pair(i, j));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = target - nums[i] - nums[j];
                if (map.find(key) != map.end()) {
                    for (auto it : map[key]) {
                        int l = it.first, r = it.second;
                        if (l > j) {
                            res.insert({nums[i], nums[j], nums[l], nums[r]});
                        }
                    }
                }
            }
        }
        return vector<vector<int>>(res.begin(), res.end());
    }
};