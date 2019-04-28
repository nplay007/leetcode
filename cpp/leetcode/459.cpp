class Solution {
public:
    bool repeatedSubstringPattern(string str) {
        string nextStr = "";
        int n = str.size();
        if(n < 1) return false;
        for(int i = 1; i <= n / 2; i++){
            if(n % i == 0){
                nextStr = str.substr(i) + str.substr(0, i);
                if(nextStr == str) return true;
            }
        }
        return false;
    }
};


   bool repeatedSubstringPattern(string str) {
        int i = 1, j = 0, n = str.size();
        vector<int> dp(n+1, 0);
        while( i < str.size() ){
            if( str[i] == str[j] ) dp[++i] = ++j;
            else if( j == 0 ) i++;
            else j = dp[j];
        }
        return dp[n] && dp[n]%(n-dp[n]) == 0;
    }