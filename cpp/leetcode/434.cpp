class Solution {
public:
    int countSegments(string s) {
        int cnts = 0;
        for(int i = 0, j; i < s.size(); i++){
            if(s[i] != ' '){
                for(j = i; j < s.size() && s[j] != ' '; j++);
                cnts++;
                i = j;
            }
        }
        return cnts;
    }
};