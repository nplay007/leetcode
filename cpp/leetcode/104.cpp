class Solution {
public:
	int maxDepth(TreeNode* root) {
		if (!root) return 0;
		return 1 + max(maxDepth(root->left), maxDepth(root->right));
	}
};

class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(!root) return 0;
        queue<TreeNode*> q;
        q.push(root);
        int res = 0;
        while(!q.empty()){
            int size = q.size();
            res ++;
            for(int i = 0; i < size; i++){
                TreeNode* node = q.front(); q.pop();
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
        }
        return res;
    }
};