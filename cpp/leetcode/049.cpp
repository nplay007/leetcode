class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        unordered_map<string, vector<string>> words;
        for(string str: strs){
            string key = str;
            sort(key.begin(), key.end());
            words[key].push_back(str);
        }
        for(auto it : words){
            sort(it.second.begin(), it.second.end());
            res.push_back(it.second);
        }
        return res;
    }
};