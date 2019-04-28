class Solution {
public:
    vector<pair<int, int>> pacificAtlantic(vector<vector<int>>& matrix) {
        vector<pair<int, int>> res;
        if(matrix.empty() || matrix[0].empty()) return res;
        int m = matrix.size(), n = matrix[0].size();
        vector<vector<bool>> pacific(m, vector<bool>(n, false));
        vector<vector<bool>> atlantic(m, vector<bool>(n, false));
        for(int i = 0; i < m; i++){
            dfs(matrix, pacific, INT_MIN, i, 0);
            dfs(matrix, atlantic, INT_MIN, i, n-1);
        }
        for(int i = 0; i < n; i++){
            dfs(matrix, pacific, INT_MIN, 0, i);
            dfs(matrix, atlantic, INT_MIN, m-1, i);
        }
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(pacific[i][j] && atlantic[i][j]){
                    res.push_back(make_pair(i, j));
                }
            }
        }
        return res;
    }
    
    void dfs(vector<vector<int>> &matrix, vector<vector<bool>>& visited, int height, int x, int y){
        int m = matrix.size(), n = matrix[0].size();
        if(x<0 || x>=m || y<0 || y>=n || visited[x][y] || matrix[x][y] < height) return;
        visited[x][y] = true;
        vector<vector<int>> dirs{{0,1},{0,-1},{1,0},{-1,0}};
        for(auto dir : dirs){
            dfs(matrix, visited, matrix[x][y], x+dir[0], y+dir[1]);
        }
    }
};