class Solution {
public:
    string minWindow(string s, string t) {
        int m = s.size(), n = t.size(), miss = t.size();
        vector<int> need(128, 0);
        for (int i = 0; i < n; i++) need[t[i]]++;
        int width = INT_MAX, start = 0, left = 0;
        for(int i = 0; i <= s.size(); ) {
            if(miss) {
                if (i == s.size()) break;
                if (--need[s[i++]] >= 0) miss--;
            } else {
                if (i - start < width) {
                    width = i - start;
                    left = start;
                }
                if (++need[s[start++]] > 0) miss ++;
            }
        }
        return width == INT_MAX? "" : s.substr(left, width);
    }
};