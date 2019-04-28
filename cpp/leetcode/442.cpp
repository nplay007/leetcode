class Solution {
    // when find a number i, flip the number at position nums[i]-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
public:
    vector<int> findDuplicates(vector<int>& nums) {
        vector<int> res;
        for(int i = 0; i < nums.size(); i++){
            int idx = abs(nums[i]) - 1;
            if(nums[idx] < 0) {
                res.push_back(idx + 1);
            }
            nums[idx] = - nums[idx];
        }
        return res;
    }
};


class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        vector<int> res;
        int i = 0;
        while (i < nums.size()) {
            if (nums[i] != nums[nums[i]-1]) swap(nums[i], nums[nums[i]-1]);
            else i++;
        }
        for (i = 0; i < nums.size(); i++) {
            if (nums[i] != i + 1) res.push_back(nums[i]);
        }
        return res;
    }
};