void connect(TreeLinkNode *root) {
    TreeLinkNode *cur, *ptr, *pre;
    cur = root;
    while(cur) {
        pre = ptr = NULL;
        while(cur){
            if(!pre) pre = cur->left? cur->left:cur->right;
            if (cur->left){
                if(ptr) ptr->next = cur->left;
                ptr = cur->left;
            }
            if (cur->right){
                if (ptr) ptr->next = cur->right;
                ptr = cur->right;
            }
            cur = cur->next;
        }
        cur = pre;
    }
}



// Recursion, more than constant space
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (!root) return;
        TreeLinkNode *p = root->next;
        while (p) {
            if (p->left) {
                p = p->left;
                break;
            }
            if (p->right) {
                p = p->right;
                break;
            }
            p = p->next;
        }
        if (root->right) root->right->next = p; 
        if (root->left) root->left->next = root->right ? root->right : p; 
        connect(root->right);
        connect(root->left);
    }
};


class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (!root) return;
        queue<TreeLinkNode*> q;
        q.push(root);
        q.push(NULL);
        while (true) {
            TreeLinkNode *cur = q.front();
            q.pop();
            if (cur) {
                cur->next = q.front();
                if (cur->left) q.push(cur->left);
                if (cur->right) q.push(cur->right);
            } else {
                if (q.size() == 0 || q.front() == NULL) return;
                q.push(NULL);
            }
        }
    }
};
