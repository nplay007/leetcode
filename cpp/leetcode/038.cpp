class Solution {
public:
    string countAndSay(int n) {
        if(n < 1) {
            return "";
        }
        string res = "1";
        while(--n){
            string tmp = "";
            int cnts = 0;
            for(int j = 0; j < res.size(); j++){
                if(j + 1 < res.size() && res[j] == res[j+1]) {
                    cnts++;
                } else{
                    cnts ++;
                    tmp += to_string(cnts) + res[j];
                    cnts = 0;
                }
            }
            res = tmp;
        }
        return res;
    }
};