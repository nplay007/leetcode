class Solution {
public:
    int maxProduct(vector<string>& words) {
        int n = words.size();
        int res = 0;
        vector<int> masks(words.size(),0);
        for(int i = 0; i < n; i++)
        	for(char ch : words[i]){
        		masks[i] |= 1 << (ch - 'a');
        	}

        for(int i = 0; i < n; i++)
        	for(int j = i+1; j < n; j++){
        		if (!(masks[i] & masks[j])){
        			res = max(res, int(words[i].size() * words[j].size()));
        		}
        	}
        return res;
    }
};