class Solution {
public:
    int characterReplacement(string s, int k) {
        int len = s.size();
        int count[26] = {0};
        int start = 0, maxCount = 0, maxLength = 0;
        for(int end = 0; end < len; end++){
            maxCount = max(maxCount, ++count[s[end] - 'A']);
            while(end - start + 1 - maxCount > k){
                count[s[start] - 'A'] --;
                start ++;
            }
            maxLength = max(maxLength, end - start + 1);
        }
        return maxLength;
    }
};


class Solution {
public:
    int characterReplacement(string s, int k) {
        int count[128] = {0};
        int maxlen = 0, start = 0;
        for(int end = 0; end < s.size(); ++end){
            maxlen = max(maxlen, ++count[s[end]]);
            if(maxlen + k <= end - start){
                count[s[start++]]--;
            }
        }
        return s.size() - start;
    }
};