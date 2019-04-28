class Solution {
public:
    int minDepth(TreeNode* root) {
        if(!root) {
            return 0;
        } else if(!root->left || !root->right) {
            return 1 + max(minDepth(root->left), minDepth(root->right));
        }
        return 1 + min(minDepth(root->left), minDepth(root->right));
    }
};



class Solution {
public:
    int minDepth(TreeNode* root) {
        if(!root) return 0;
        queue<TreeNode* > q;
        q.push(root);
        int res = 0;
        while(!q.empty()){
            int size = q.size();
            res ++;
            for(int i = 0; i < size; ++i){
                TreeNode *node = q.front(); q.pop();
                if(!node->left && !node->right) return res;
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
        }
        return res;
    }
};