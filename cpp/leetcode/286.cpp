class Solution {
public:
    void wallsAndGates(vector<vector<int>>& rooms) {
        if (rooms.empty()) return;
        int m = rooms.size(), n = rooms[0].size();
        queue<pair<int, int>> q;
        vector<pair<int, int>> dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!rooms[i][j]) q.push(make_pair(i, j));
            }
        }
        while (!q.empty()) {
            int r = q.front().first, c = q.front().second; q.pop();
            for (auto dir : dirs) {
                int x = r + dir.first, y = c + dir.second;
                if (x < 0 || y < 0 || x >= m || y >= n || rooms[x][y] <= rooms[r][c] + 1) continue;
                rooms[x][y] = rooms[r][c] + 1;
                q.push(make_pair(x, y));
            }
        }
    }
};