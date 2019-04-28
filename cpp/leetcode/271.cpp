class Codec {
public:
    string encode(vector<string>& strs) {
        string res = "";
        for(auto str : strs) res += to_string(str.size()) + "#" + str;
        return res;
    }

    vector<string> decode(string s) {
        vector<string> res;
        for(int i = 0; i < s.size(); ){
            int idx = s.find_first_of('#', i);
            int len = stoi(s.substr(i, idx - i));
            res.push_back(s.substr(idx + 1, len));
            i = idx + len + 1;
        }
        return res;
    }
};