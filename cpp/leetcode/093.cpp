vector<string> restoreIpAddresses(string s) {
    vector<string> res;
    string ans;
    for (int a=1; a<=3; a++)
    for (int b=1; b<=3; b++)
    for (int c=1; c<=3; c++)
    for (int d=1; d<=3; d++)
        if (a+b+c+d == s.length()) {
            int A = stoi(s.substr(0, a));
            int B = stoi(s.substr(a, b));
            int C = stoi(s.substr(a+b, c));
            int D = stoi(s.substr(a+b+c, d));
            if (A<=255 && B<=255 && C<=255 && D<=255){
                ans = to_string(A)+"."+to_string(B)+"."+to_string(C)+"."+to_string(D);
                if (ans.size() == s.size() + 3) res.push_back(ans);
        }    
    return res;
}


class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> res;
        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++){
                for(int k = 1; k < 4; k++){
                    for(int l = 1; l < 4; l++){
                        if(i +j + k +l == s.size()){ 
                            string s1 = s.substr(0, i);
                            string s2 = s.substr(i, j);
                            string s3 = s.substr(i+j, k);
                            string s4 = s.substr(i+j+k, l);
                            if(valid(s1) && valid(s2) && valid(s3) && valid(s4)){
                                res.push_back(s1 + "." + s2 + "." + s3 + "." + s4);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    
    bool valid(string s){
        int n = stoi(s);
        if(n < 0 || n > 255 || to_string(n).size() != s.size()) return false;
        return true;
    }
};