class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if(!p || !q) {
            return p == q;
        }
        if(p->val != q->val){
            return false;
        }
        return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
    }
};


class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if(!p || !q) {
            return p == q;
        }
        queue<TreeNode*> q1, q2;
        q1.push(p);
        q2.push(q);
        while(!q1.empty() && !q2.empty()){
            auto n1 = q1.front(); q1.pop();
            auto n2 = q2.front(); q2.pop();
            if(n1->val != n2->val) {
                return false;
            }
            if(n1->left) {
                q1.push(n1->left);
            }
            if(n2->left) {
                q2.push(n2->left);
            }
            if(q1.size() != q2.size()) {
                return false;
            }
            if(n1->right) {
                q1.push(n1->right);
            }
            if(n2->right) {
                q2.push(n2->right);
            }
            if(q1.size() != q2.size()) {
                return false;
            }
        }
        return q1.size() == q2.size();
    }
};