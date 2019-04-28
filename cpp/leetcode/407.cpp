class Solution {
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        if(heightMap.empty()) return 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
        int m = heightMap.size(), n = heightMap[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        int ans = 0, Max = INT_MIN;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!(i == 0 || i == m-1 || j == 0 || j == n-1)) continue;
                q.push(make_pair(heightMap[i][j], i*n+j));
                visited[i][j] = 1;
            }
        }
        vector<vector<int>> dir{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.empty()) {
            auto val = q.top(); q.pop();
            int height = val.first, x = val.second/n, y = val.second%n;
            Max = max(Max, height);
            for(auto d: dir) {
                int x2 = x + d[0], y2 = y + d[1];
                if(x2>=m || x2<0 || y2<0 || y2>=n || visited[x2][y2]) continue;
                visited[x2][y2] = 1;
                if(heightMap[x2][y2] < Max) ans += Max - heightMap[x2][y2];
                q.push(make_pair(heightMap[x2][y2], x2*n+y2));
            }
        }
        return ans;
    }
};