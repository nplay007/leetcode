class Solution {
  public:
    vector<int> findSubstring(string s, vector<string> &words) {
        vector<int> res;
        unordered_map<string, int> wmap;
        int m = words.size(), n = words[0].size();
        for (string str : words) {
            wmap[str]++;
        }
        for (int i = 0; i < s.size() - m * n + 1; i++) {
            int j = 0;
            unordered_map<string, int> smap;
            for (; j < m; j++) {
                string key = s.substr(i + j * n, n);
                if (wmap.find(key) == wmap.end()) {
                    break;
                }
                if (++smap[key] > wmap[key]) {
                    break;
                }
            }
            if (j == m) {
                res.push_back(i);
            }
        }
        return res;
    }
};