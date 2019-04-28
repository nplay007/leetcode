class Solution {
  public:
    vector<string> letterCombinations(string digits) {
        vector<string> res;
        if (digits.empty()) {
            return res;
        }
        unordered_map<char, string> board{{'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"}, {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}};
        help(0, digits, board, "", res);
        return res;
    }

    void help(int n, string digits, unordered_map<char, string> &board, string ans, vector<string> &res) {
        if (n == digits.size()) {
            res.push_back(ans);
            return;
        }
        for (int i = 0; i < board[digits[n]].size(); i++) {
            // ans += board[digits[n]][i];
            help(n + 1, digits, board, ans + board[digits[n]][i], res);
            // ans.pop_back();
        }
    }
};

// Iterative
class Solution {
  public:
    vector<string> letterCombinations(string digits) {
        vector<string> res;
        if (digits.empty()) {
            return res;
        }
        unordered_map<char, string> board{{'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"}, {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}};
        res.push_back("");
        for (int i = 0; i < digits.size(); i++) {
            int n = res.size();
            for (int j = 0; j < n; j++) {
                string tmp = res.front();
                res.erase(res.begin());
                for (int k = 0; k < board[digits[i]].size(); k++) {
                    res.push_back(tmp + board[digits[i]][k]);
                }
            }
        }
        return res;
    }
};