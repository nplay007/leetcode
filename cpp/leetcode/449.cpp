class Codec {
public:
    void serialize(TreeNode* root, ostringstream& out ) {
        if ( !root ) return;
        out << root->val << ",";
        serialize(root->left, out);
        serialize(root->right, out);
    }
    
    string serialize(TreeNode* root) {
        ostringstream ss;
        serialize(root, ss);
        return ss.str();
    }

    TreeNode* deserialize(const string& s, int lower, int upper, int & pos ) {
        // pos is a variable to record the end of decoded buffer 
        if ( pos == s.size() ) return nullptr;
        int cur = pos;
        int number = 0;
        while( s[cur] != ',') {
            number = number * 10 + s[cur] - '0';
            ++cur;
        }
        ++cur;
        // The next number is not part of current subtree, should return nullptr
        if ( number < lower || number > upper ) return nullptr;
        TreeNode* root = new TreeNode( number );
        pos = cur; // update pos 
        root->left =  deserialize( s, lower, root->val, pos );
        root->right = deserialize( s, root->val, upper, pos );
        return root;
    }
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        int pos = 0;
        return deserialize( data, INT_MIN, INT_MAX, pos );
        
    }
};