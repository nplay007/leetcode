class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (!root) return;
        if (root->left) root->left->next = root->right;
        if (root->right) root->right->next = root->next? root->next->left : NULL;
        connect(root->left);
        connect(root->right);
    }
};



class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (!root) return;
        queue<TreeLinkNode*> q;
        q.push(root);
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeLinkNode *t = q.front(); q.pop();
                if (i < size - 1) t->next = q.front();
                if (t->left) q.push(t->left);
                if (t->right) q.push(t->right);
            }
        }
    }
};


class Solution {
public:
    void connect(TreeLinkNode *root) {
        if(!root) return;
        TreeLinkNode *start = root, *ptr = NULL;
        while(start->left){
            ptr = start;
            while(ptr){
                ptr->left->next = ptr->right;
                if(ptr->next) ptr->right->next = ptr->next->left;
                ptr = ptr->next;
            }
            start = start->left;
        }
        return ;
    }
};