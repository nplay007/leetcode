class Solution {
public:
    string largestNumber(vector<int> &nums) {
        vector<string> ans;
        string res;
        for (int i : nums) {
            ans.push_back(to_string(i));
        }
        sort(ans.begin(), ans.end(), compare);
        for (string s : ans) {
            res += s;
        }
        if (res[0] == '0' && res.size() > 0) {
            return "0";
        }
        return res;
    }

  private:
    static bool compare(string &s1, string &s2) {
        return s1 + s2 > s2 + s1;
    }
};

class Solution {
public:
    string largestNumber(vector<int> &nums) {
        if (nums.empty()) {
            return "";
        }
        string res = "";
        vector<string> strs;
        for (auto num : nums) {
            strs.push_back(to_string(num));
        }
        sort(strs.begin(), strs.end(), [](string s1, string s2) { return s1 + s2 > s2 + s1; });
        for (auto str : strs) {
            res += str;
        }
        if (res.size() > 0 && res[0] == '0') {
            return "0";
        }
        return res;
    }
};