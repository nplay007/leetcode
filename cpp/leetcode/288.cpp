class ValidWordAbbr {
public:
    ValidWordAbbr(vector<string> &dictionary) {
        for(auto word : dictionary){
            string key = word[0] + to_string(word.size()) + word.back();
            data[key].insert(word);
        }
    }

    bool isUnique(string word) {
        string key = word[0] + to_string(word.size()) + word.back();
        auto words = data[key];
        return words.count(word) == words.size();
    }
private:
    unordered_map<string, unordered_set<string>> data;
};