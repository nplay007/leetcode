class Solution {
public:
    bool isValidSerialization(string preorder) {
        if (preorder.empty()) {
            return false;
        }
        preorder += ',';
        int diff = 1;
        for (int i = 0; i < preorder.size(); i++) {
            if (preorder[i] != ',') {
                continue;
            }
            diff--;
            if (diff < 0) {
                return false;
            }
            if (preorder[i - 1] != '#') {
                diff += 2;
            }
        }
        return diff == 0;
    }
};