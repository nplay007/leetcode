class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        return help(root, root);
    }
    bool help(TreeNode *left, TreeNode *right){
        if(!left || !right) return left == right;
        if(left->val == right->val) 
            return help(left->left, right->right) && help(left->right, right->left);
        else return false;
    }
};



class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(!root) return true;
        queue<TreeNode*> q;
        q.push(root); q.push(root);
        while(!q.empty()){
            TreeNode* left = q.front(); q.pop();
            TreeNode* right = q.front(); q.pop();
            if(!left || !right){
                if(left == right) continue;
                else return false;
            }
            if(left->val != right->val) return false;
            q.push(left->left); q.push(right->right);
            q.push(left->right); q.push(right->left);
        }
        return true;
    }
};