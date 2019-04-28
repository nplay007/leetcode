class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        dfs(n, n, "", res);
        return res;
    }
    void dfs(int l, int r, string ans, vector<string> &res) {
        if (l == 0 && r == 0) {
            res.push_back(ans);
        }
        if (l > 0 && l <= r) {
            dfs(l - 1, r, ans + "(", res);
        }
        if (r > 0 && l <= r) {
            dfs(l, r - 1, ans + ")", res);
        }
    }
};