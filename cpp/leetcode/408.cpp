class Solution {
public:
    bool validWordAbbreviation(string word, string abbr) {
        if(word.empty() || abbr.empty()) return word == abbr;
        int i = 0, j = 0;
        while(i < word.size() && j < abbr.size()){
            if(isalpha(abbr[j])){
                if(abbr[j] == word[i]) {j++; i++;}
                else return false;
            } else {
                if (abbr[j] == '0') return false; // impossible abbr
                int tmp = 0;
                while(j < abbr.size() && isdigit(abbr[j]))  tmp = 10 * tmp + abbr[j++] - '0';
                i += tmp;
            }
        }
        return i == word.size() && j == abbr.size();
    }
};