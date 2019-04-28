class Solution {
public:
    string removeKdigits(string num, int k) {
        int n = num.size();
        string res = "";
        int left = n - k;
        for(auto ch : num){
            while(k && !res.empty() && res.back() > ch){
                res.pop_back();
                k--;
            }
            res.push_back(ch);
        }
        res.resize(left); // remove tail 
        while(!res.empty() && res[0] == '0') res.erase(res.begin());
        return res.empty() ? "0" : res;
    }
};