class Solution {
public:
    string toHex(int num) {
        if(num == 0) return "0";
        string res = "";
        for(int i = 0; i < 8; i++){
            res = map[num & 15] + res; // 1111b
            num >>= 4;
        }
        auto idx = res.find_first_not_of('0');
        return res.substr(idx);
    }
private:
    const string map = "0123456789abcdef";
};