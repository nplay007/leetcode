#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;
class Solution {
  public:
    vector<int> twoSum(vector<int> &nums, int target) {
        vector<int> res(2);
        unordered_map<int, int> sums;
        for (int i = 0; i < nums.size(); ++i) {
            if (sums.find(target - nums[i]) != sums.end()) {
                res[0] = sums[target - nums[i]];
                res[1] = i;
                return res;
            }
            sums[nums[i]] = i;
        }
        throw invalid_argument("Can't find two sum for input");
    }
};