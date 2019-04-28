class Solution {
public:
    bool canWin(string s) {
        if(s.empty()) return false;
        for(int i = 0; i < s.size() - 1; i++){
            if(s.substr(i, 2) == "++"){
                if(!canWin(s.substr(0, i) + "--" + s.substr(i+2))) return true;
            }
        }
        return false;
    }
};