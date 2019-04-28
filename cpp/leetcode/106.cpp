class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
         return help(0, inorder.size() - 1, inorder, 0, postorder.size() - 1, postorder);
    }
    
    TreeNode* help(int is, int ie, vector<int>& inorder, int ps, int pe, vector<int>& postorder){
        if(ps > pe || is > ie) return NULL;
        int val = postorder[pe];
        TreeNode* root = new TreeNode(val);
        int idx = find(inorder.begin()+is, inorder.begin() + ie, val) - inorder.begin();
        root->left = help(is, idx - 1, inorder, ps, idx - is + ps - 1, postorder);
        root->right = help(idx + 1, ie, inorder, idx - is + ps, pe -1 , postorder);
        return root;
    }       
};