class Solution {
public:
    bool isAdditiveNumber(string num) {
        if(num.empty()) return true;
        int n = num.size();
        for(int i = 1; i <= n/2; ++i){ // at most half the string 
            for(int j = 1; j <= (n-i)/2; ++j){ // at most half of the left string 
                if(check(num.substr(0, i), num.substr(i, j), num.substr(i+j))) return true;
            }
        }
        return false;
    }
    
    bool check(string n1, string n2, string n3){
        if(n1.size() > 1 && n1[0] == '0' || n2.size() > 1 && n2[0] == '0') return false;
        string res =  add(n1, n2);
        if(res == n3) return true;
        if(n3.size() <= res.size() || res.compare(n3.substr(0, res.size())) != 0) return false;
        else return check(n2, res, n3.substr(res.size()));
    }
    
    string add(string n1, string n2){
        string res ="";
        int i = n1.size() - 1, j = n2.size() - 1, carry = 0;
        while(i >= 0 || j >= 0 || carry){
            int x = i >= 0 ? n1[i--] - '0' : 0;
            int y = j >= 0 ? n2[j--] - '0' : 0;
            int tmp = x + y + carry;
            res.push_back(tmp % 10 + '0');
            carry = tmp / 10;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};