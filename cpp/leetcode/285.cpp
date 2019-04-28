class Solution {
public:
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        if(p->right){
            TreeNode* node = p->right;
            while(node->left) node = node->left;
            return node;
        }
        TreeNode *node = NULL;
        while(root){
            if(root->val > p->val){
                node = root;
                root = root->left;
            } else if (root->val < p->val) {
                root = root->right;
            } else return node;
        }
        return node;
    }
};