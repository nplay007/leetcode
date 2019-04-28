class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root) return root;
        if((root->val - p->val) * ( root->val - q->val) > 0){
            if(root->val > p->val){
                return lowestCommonAncestor(root->left, p, q);
            } else {
                return lowestCommonAncestor(root->right, p, q);
            }
        } else {
            return root;
        }
    }
};

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root) return root;
        while((root->val - p->val) * ( root->val - q->val) > 0){
            root = root->val > p->val ? root->left: root->right;
        }
        return root;
    }
};