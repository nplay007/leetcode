class Solution {
    vector<int> arr, idx;
public:
    Solution(vector<int> nums) {
        arr.resize(nums.size());
        idx.resize(nums.size());
        for (int i = 0; i < nums.size(); i++){
            arr[i] = nums[i];
            idx[i] = nums[i];
        }
    }
    
    vector<int> reset() {
        for (int i = 0; i < arr.size(); i++)
            arr[i] = idx[i];
        return arr;    
    }
    
    vector<int> shuffle() {
         for(int i = arr.size() - 1; i > 0; i--) {
            int j = rand() % (i + 1);
            swap(arr[i], arr[j]);
         }
         return arr;    
    }
};