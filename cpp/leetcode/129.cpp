class Solution {
public:
    int sumNumbers(TreeNode* root) {
        if(!root) return 0;
        stack<TreeNode*> stk;
        TreeNode *cur = root, *pre = NULL;
        int res = 0, tmp = 0;
        while(cur || !stk.empty()){
            while(cur){
                stk.push(cur);
                tmp = 10 * tmp + cur->val;
                cur = cur->left;
            }
            cur = stk.top();
            if(!cur->left && !cur->right) res += tmp;
            if(cur->right && pre != cur->right){
                cur = cur->right;
            } else {
                stk.pop();
                pre = cur;
                tmp = tmp / 10;
                cur = NULL;
            }
        }
        return res;
    }
};




class Solution {
public:
    int sumNumbers(TreeNode* root) {
        int res = 0;
        help(root, 0, res);
        return res;
    }
    
    void help(TreeNode* root, int target, int &res){
        if(!root) return;
        if(!root->left && !root->right){
            target = 10 * target + root->val;
            res += target;
            return;
        }
        help(root->left, 10 * target + root->val, res);
        help(root->right, 10 * target + root->val, res);
    }
};