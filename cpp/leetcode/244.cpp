class WordDistance {
public:
    WordDistance(vector<string>& words) {
        for(int i = 0; i < words.size(); i++)
            dict[words[i]].push_back(i);
    }
    int shortest(string word1, string word2) {
        int  i = 0, j = 0, dist = INT_MAX;
        while(i < dict[word1].size() && j <dict[word2].size()) { 
            dist = min(dist, abs(dict[word1][i] - dict[word2][j]));
            dict[word1][i] < dict[word2][j] ? i++: j++;
        }
        return dist;
    }
private:
    unordered_map<string, vector<int>> dict;
};