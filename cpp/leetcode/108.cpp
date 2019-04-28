class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return help(0, nums.size() - 1, nums);
    }
    
    TreeNode* help(int start, int end, vector<int> & nums){
        if(start > end) {
            return nullptr;
        } else {
            int mid = (end - start) / 2 + start;
            TreeNode* root = new TreeNode(nums[mid]);
            root->left = help(start, mid - 1, nums);
            root->right = help(mid + 1, end, nums);
            return root;
        }
    }
};