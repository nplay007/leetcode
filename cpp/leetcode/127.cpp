class Solution {
public:
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordList) {
        queue<string> q;
        q.push(beginWord);
        int cnts = 1;
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                string word = q.front(); q.pop();
                if(word == endWord) return cnts;
                wordList.erase(word);
                for(int j = 0; j < word.size(); j++){
                    char ch = word[j];
                    for(int k = 0; k < 26; k++){
                        word[j] = 'a' + k;
                        if(wordList.find(word) != wordList.end()){
                            q.push(word); wordList.erase(word);
                        }
                    }
                    word[j] = ch;
                }
            }
            cnts++;
        }
        return 0;
    }
};