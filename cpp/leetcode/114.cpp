class Solution {
public:
    void flatten(TreeNode* root) {
        while(root){
            if(root->left){
                TreeNode *node = root->left;
                while(node->right) node = node->right;
                node->right = root->right;
                root->right = root->left;
                root->left = NULL;
            } else {
                root = root->right;
            }
        }
        return;
    }
};