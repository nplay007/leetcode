class BSTIterator {
    stack<TreeNode *> stk;
public:
    BSTIterator(TreeNode *root) {
        pushAll(root);
    }

    bool hasNext() {
        return !stk.empty();
    }

    int next() {
        TreeNode *node = stk.top();
        stk.pop();
        pushAll(node->right);
        return node->val;
    }

private:
    void pushAll(TreeNode *node) {
        while(node){
            stk.push(node);
            node = node->left;
        }
    }
};