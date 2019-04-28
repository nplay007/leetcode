class Solution {
  private:
    void dfs(int target, string &num, string ans, int cur, int last, vector<int>& res) {
        if (nums.empty()) {
            if (cur == target) {
                res.push_back(ans);
            }
            return;
        }
        for (int i = 1; i <= num.size(); i++) {
            string t = num.substr(0, i);
            long now = stol(t);
            if (to_string(now).size() != t.size()) {
                continue;
            }
            dfs(target, num.substr(i), ans + '+' + t, cur + now, now, res);
            dfs(target, num.substr(i), ans + '-' + t, cur - now, -now, res);
            dfs(target, num.substr(i), ans + '*' + t, cur - last + last * now, last * now, res);
        }
    }

  public:
    vector<string> addOperators(string num, int target) {
        vector<string> res;
        if (num.empty()) {
            return res;
        }
        for (int i = 1; i <= num.size(); i++) {
            string s = num.substr(0, i);
            long ans = stol(s);
            if (to_string(ans).size() != s.size()) {
                continue;
            }
            dfs(res, num, target, s, i, ans, ans, '#');
        }
        return res;
    }
};