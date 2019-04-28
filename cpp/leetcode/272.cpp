class Solution {
public:
    vector<int> closestKValues(TreeNode* root, double target, int k) {
        vector<int>res;
        stack<int> s1;
        stack<int> s2;
        inorder(root, target, false, s1);
        inorder(root, target, true, s2);
        while(k-->0){
            if(s1.empty()) {res.push_back(s2.top()); s2.pop();}
            else if(s2.empty()) {res.push_back(s1.top()); s1.pop();}
            else if(abs(s1.top() - target) < abs(s2.top() - target)) {res.push_back(s1.top()); s1.pop();}
            else {res.push_back(s2.top()); s2.pop();}
        }
        return res;
    }
    
    void inorder(TreeNode* root, double target, bool flag, stack<int> &stk){
        if(!root) return;
        inorder(flag? root->right: root->left, target, flag, stk);
        if((flag && root->val <= target) || (!flag && root->val > target)) return;
        stk.push(root->val);
        inorder(flag? root->left: root->right, target, flag, stk);
    }
};