class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char,int> words;
        vector<string> bucket(s.size() + 1, "");
        string res;
        
        for(char ch:s) words[ch]++;
        for(auto& it: words) {
            int n = it.second;
            char ch = it.first;
            bucket[n].append(n, ch);
        }
        for(int i = s.size(); i > 0; i--) {
            if(!bucket[i].empty()) res.append(bucket[i]);
        }
        return res;
    }
};


class Solution {
public:
    string frequencySort(string s) {
        int counts[256] = {0};
        for (char ch : s)
            ++counts[ch];
        sort(s.begin(), s.end(), [](char a, char b) { 
            return counts[a] > counts[b] || (counts[a] == counts[b] && a < b); 
        });
        return s;
    }
};