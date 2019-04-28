class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = haystack.size(), m = needle.size();
        for(int i = 0; i <= n - m; i++){
            if(haystack.substr(i, m) == needle) {
                return i;
            }
        }
        return -1;
    }
};

class Solution {
public:
    int strStr(string haystack, string needle) {
        if (needle.empty()) {
            return 0;
        }
        int m = needle.size();
        vector<int> next(m, 0);
        for (int i = 1; i < m; i++) {
            int j = next[i-1];
            while (j > 0 && needle[i] != needle[j]) {
                j = next[j-1];
            }
            if (needle[i] == needle[j]) {
                next[i] = j + 1;
            }
        }
        for(int i = 0, j = 0; i < haystack.size(); i++){
            while (j > 0 && needle[j] != haystack[i]) {
                j = next[j-1];
            }
            if (needle[j] == haystack[i]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
};