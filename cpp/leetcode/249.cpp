class Solution {
public:
    vector<vector<string>> groupStrings(vector<string>& strings) {
        unordered_map<string, vector<string>> map;
        vector<vector<string>> res;
        for(auto strs: strings){
            string key = "";
            for(int i = 0; i < strs.size(); i++){
                key += char((strs[i] - strs[0] + 26)%26 + 'a');
            }
            map[key].push_back(strs);
        }
        for(auto item:map) res.push_back(item.second);
        return res;
    }
};