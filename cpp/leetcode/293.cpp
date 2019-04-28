class Solution {
public:
    vector<string> generatePossibleNextMoves(string s) {
        vector<string> moves;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == '+' && s[i + 1] == '+') { 
                moves.push_back(s.substr(0, i) + "--" + s.substr);
            }
        }
        return moves;
    }
};