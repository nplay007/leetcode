class Solution {
public:
    int numIslands(vector<vector<char>> &grid) {
        if (grid.empty() || grid[0].empty()) {
            return 0;
        }
        int m = grid.size(), n = grid[0].size();
        vector<vector<bool>> visit(m, (vector<bool>(n, false)));
        int cnts = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    cnts++;
                    dfs(i, j, m, n, grid, visit);
                }
            }
        }
        return cnts;
    }

    void dfs(int i, int j, int m, int n, vector<vector<char>> &grid, vector<vector<bool>> &visit) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' || visit[i][j]) {
            return;
        }
        visit[i][j] = true;
        dfs(i + 1, j, m, n, grid, visit);
        dfs(i - 1, j, m, n, grid, visit);
        dfs(i, j + 1, m, n, grid, visit);
        dfs(i, j - 1, m, n, grid, visit);
    }
};

class Solution {
public:
    int numIslands(vector<vector<char>> &grid) {
        if (grid.empty()) {
            return 0;
        }
        int m = grid.size(), n = grid[0].size();
        int cnts = 0;
        vector<vector<bool>> check(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !check[i][j]) {
                    bfs(i, j, m, n, check, grid);
                    cnts++;
                }
            }
        }
        return cnts;
    }

    void bfs(int i, int j, int m, int n, vector<vector<bool>> &check, vector<vector<char>> &grid) {
        check[i][j] = true;
        queue<vector<int>> q;
        q.push({i, j});
        while (!q.empty()) {
            int x = q.front()[0], y = q.front()[1];
            q.pop();
            if (x - 1 >= 0 && !check[x - 1][y] && grid[x - 1][y] == '1') {
                q.push({x - 1, y});
                check[x - 1][y] = true;
            }
            if (x + 1 < m && !check[x + 1][y] && grid[x + 1][y] == '1') {
                q.push({x + 1, y});
                check[x + 1][y] = true;
            }
            if (y - 1 >= 0 && !check[x][y - 1] && grid[x][y - 1] == '1') {
                q.push({x, y - 1});
                check[x][y - 1] = true;
            }
            if (y + 1 < n && !check[x][y + 1] && grid[x][y + 1] == '1') {
                q.push({x, y + 1});
                check[x][y + 1] = true;
            }
        }
    }
};