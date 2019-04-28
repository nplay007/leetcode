class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        if(!root) return false;
        if(!root->left && !root->right) return root->val == sum;
        sum -= root->val;
        return hasPathSum(root->left, sum) || hasPathSum(root->right, sum);
    }
};



class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        if(!root) return false;
        stack<TreeNode*> stk;
        TreeNode *node = root, *pre = NULL;
        int res = 0;
        while(node || !stk.empty()){
            while(node){
                stk.push(node);
                res += node->val;
                node = node->left;
            }
            node = stk.top();
            if(!node->left && !node->right && sum == res) return true;
            if(node->right && pre != node->right){
                node = node->right;
            } else {
                pre = node;
                stk.pop();
                res -= node->val;
                node = NULL;
            }
        }
        return false;
    }
};