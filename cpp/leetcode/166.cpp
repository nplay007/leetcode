class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        string res = "";
        res += (numerator < 0) ^ (denominator < 0) ? "-" : "";
        long n = labs(numerator), d = labs(denominator);
        res += to_string(n / d);
        if(n % d == 0) return res;
        res += ".";
        unordered_map<long, int> map;
        for(long r = n % d; r; r %= d){
            if(map.find(r) != map.end()){
                res.insert(map[r], 1, '(');
                res += ")";
                break;
            }
            map[r] = res.size();
            r *= 10;
            res += to_string(r/d);
        }
        return res;
    }
};