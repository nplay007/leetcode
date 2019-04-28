class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        int m = s.length(), n = t.length();
        if (m > n) return isOneEditDistance(t, s);
        if (n - m > 1) return false;
        bool mismatch = false;
        for (int i = 0; i < m; i++) {
            if (s[i] != t[i]) {
                if (m == n) s[i] = t[i];
                else s.insert(i, 1, t[i]);
                mismatch = true; 
                break;
            }
        }
        return (!mismatch && n - m == 1) || (mismatch && s == t);
    }
};


class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        if(s.empty() && t.empty()) return false;
        int m = s.size(), n = t.size();
        if(abs(m - n) > 1) return false;
        if(m > n) return isOneEditDistance(t, s);
        int i = 0, diff = n - m;
        while(i < m && s[i] == t[i]) i ++;
        if(diff == 0){
            i ++;
            while(i < m && s[i] == t[i]) i ++;
            return i == m;
        } else {
            while(i < m && s[i] == t[i+1]) i ++;
            return i == m;
         }
    }
};