class Solution {
public:
    bool isSubsequence(string s, string t) {
        if (s.size() > t.size()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.size() && j < t.size()) {
            if (s[i] == t[j]) {
                i++;
            }
            j++;
        }
        return i == s.size();
    }
};

class Solution {
public:
    bool isSubsequence(string s, string t) {
        //build a record the index of each char in t
        vector<vector<int>> record(26);
        //add indexs
        for (int i = 0; i < t.size(); i++) {
            record[t[i] - 'a'].push_back(i);
        }
        //check if each char in s is in the legal place
        int index = -1;
        for (int i = 0; i < s.size(); i++) {
            auto iter = upper_bound(record[s[i] - 'a'].begin(), record[s[i] - 'a'].end(), index);
            if (iter == record[s[i] - 'a'].end()) {
                return false;
            }
            index = *iter;
        }
        return true;
    }
};