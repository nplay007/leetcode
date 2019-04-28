class Solution {
public:
    int minTotalDistance(vector<vector<int>>& grid) {
        vector<int> x, y;
        int m = grid.size(), n = grid[0].size();
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j]){
                    x.push_back(i);
                    y.push_back(j);
                }
            }
        }
        nth_element(x.begin(), x.begin() + x.size()/2, x.end());
        nth_element(y.begin(), y.begin() + y.size()/2, y.end());
        int xMid = x[x.size()/2], yMid = y[y.size()/2];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]){
                    res += abs(xMid - i) + abs(yMid - j);
                }
            }
        }
        return res;
    }
};