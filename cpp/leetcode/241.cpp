class Solution {
public:
    vector<int> diffWaysToCompute(string input) {
        vector<int> res;
        for(int i = 0; i < input.size(); i++){
            if(ispunct(input[i])){
                for(int l : diffWaysToCompute(input.substr(0, i))){
                    for(int r : diffWaysToCompute(input.substr(i+1))){
                        res.push_back(input[i] == '+' ? l + r : input[i] == '-' ? l - r : l * r);
                    }
                }
            }
        }
       return res.empty() ? vector<int>{stoi(input)} : res;
    }
};