class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return help(0, preorder.size() - 1, preorder, 0, inorder.size() - 1, inorder);
    }
    
    TreeNode* help(int ps, int pe, vector<int>& preorder, int is, int ie, vector<int>& inorder){
        if(ps > pe || is > ie) return NULL;
        int val = preorder[ps];
        TreeNode* root = new TreeNode(val);
        int idx = find(inorder.begin()+is, inorder.begin() + ie, val) - inorder.begin();
        root->left = help(ps+1, idx - is + ps, preorder, is, idx - 1, inorder);
        root->right = help(idx-is+ps + 1, pe, preorder, idx + 1, ie, inorder);
        return root;
    }
};