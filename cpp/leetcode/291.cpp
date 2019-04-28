class Solution {
public:
    bool wordPatternMatch(string pattern, string str) {
        unordered_map<char, string> m;
        unordered_set<string> s;
        return help(pattern, 0, str, 0, m, s);
    }
    bool help(string pattern, int p, string str, int r, unordered_map<char, string> &m, unordered_set<string> &s) {
        if (p == pattern.size() && r == str.size()) return true;
        if (p == pattern.size() || r == str.size()) return false;
        char ch = pattern[p];
        for (int i = r; i < str.size(); ++i) {
            string t = str.substr(r, i - r + 1);
            if (m.count(ch) && m[ch] == t) {
                if (help(pattern, p + 1, str, i + 1, m, s)) return true;
            } else if (!m.count(ch)) {
                if (s.count(t)) continue;
                m[ch] = t;
                s.insert(t);
                if (help(pattern, p + 1, str, i + 1, m, s)) return true;
                m.erase(ch);
                s.erase(t);
            }
        }
        return false;
    }
};