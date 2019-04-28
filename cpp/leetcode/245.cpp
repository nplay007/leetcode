class Solution {
public:
    int shortestWordDistance(vector<string>& words, string word1, string word2) {
        int m = words.size();
        int idx1 = -1, idx2 = -1, res = m + 1;
        int flag = word1 == word2;
        for(int i = 0; i < m; ++i){
            if(word1 == words[i]) idx1 = i;
            if(word2 == words[i]) { 
                if(flag) idx1 = idx2; // swap
                idx2 = i;
            }
            if(idx1 != -1 && idx2 != -1){
                res = min(res, abs(idx2 - idx1));
            }
        }
        return res;
    }
};