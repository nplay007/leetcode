class Solution {
public:
    vector<int> getRow(int rowIndex) {
        if(rowIndex < 0) return {};
        vector<int> res(rowIndex + 1);
        for(int i = 0; i <= rowIndex; i++){
            for(int j = i; j >= 0; --j){
                if(j == 0 || j == i) res[j] = 1;
                else res[j] += res[j-1];
            }
        }
        return res;
    }
};