#include <iostream>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        string t = "^";
        for(int i = 0; i < s.size(); ++i){
            t += "#" + s.substr(i, 1);
        }
        t += "#$";
        int n = t.size();
        vector<int> dp(n, 0);
        int cid = 0, right = 0, mid = 0, span = 0;
        for(int i = 1; i < n-1; ++i){
            dp[i] = right > i ? min(right - i, dp[2*cid - i]) : 0;
            while(t[i - 1 - dp[i]] == t[i + 1 + dp[i]]) dp[i] ++;
            if(dp[i] + i > right){
                right = dp[i] + i;
                cid = i;
            }
            if(dp[i] > span){
                mid = i;
                span = dp[i];
            }
        }
        return s.substr((mid - span)/2, span);
    }
};



class Solution {
public:
    string longestdpalindrome(string s) {
        int start = 0, maxlen = 0;
        for(int i =0;i < s.size(); i++){
            int l1 = extend(s, i, i);
            int l2 = extend(s, i, i+1);
            int len = max(l1, l2);
            if(len > maxlen){
                start = i - (len - 1) / 2;
                maxlen = len;
            }
        }
        return s.substr(start, maxlen);
    }

    int extend(string s, int left, int right){
        int L = left, R = right;
        while(L >= 0 && R < s.size() && s[L] == s[R]){
            L--;
            R++;
        }
        return R - L - 1;
    }
};