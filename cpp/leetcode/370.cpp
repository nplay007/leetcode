#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> getModifiedArray(int length, vector<vector<int>>& updates) {
        vector<int> nums(length, 0);
        for(auto update : updates){
            int start = update[0], end = update[1], inc = update[2];
            nums[start] += inc;
            if(end < length - 1) nums[end + 1] -= inc;
        }
        int ans = 0;
        for(int i = 0; i < length; i++){
            ans += nums[i];
            nums[i] = ans;
        }
        return nums;
    }
};