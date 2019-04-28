class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        if(matrix.empty() || matrix[0].empty()) return 0;
        int m = matrix.size(), n = matrix[0].size();
        vector<vector<int>> cache(m, vector<int>(n, 0));
        int res = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                res = max(res, len);
            }
        }   
        return res;
    }
    
    int dfs(vector<vector<int>> &matrix, int i, int j, int m, int n, vector<vector<int>> &cache) {
        if(cache[i][j] != 0) return cache[i][j];
        int res = 1;
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(auto dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            res = max(res, len);
        }
        cache[i][j] = res;
        return res;
    }
};