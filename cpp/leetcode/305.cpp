class Solution {
public:
    vector<int> numIslands2(int m, int n, vector<pair<int, int>>& positions) {
        vector<int> res;
        vector<int> root(m * n, -1);
        vector<pair<int, int>> dp = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int island = 0;
        for (auto it : positions) {
            int x = it.first, y = it.second, idx = x * n + y; // idx is the new point
            root[idx] = idx;
            ++island;
            for (auto p : dp) {
                int i = x + p.first, j = y + p.second, pos = i * n + j;
                if (i >= 0 && i < m && j >= 0 && j < n && root[pos] != -1) {
                    int rootPos = pos, rootIdx = idx;
                    while(rootPos != root[rootPos]) rootPos = root[rootPos];
                    while(rootIdx != root[rootIdx]) rootIdx = root[rootIdx];
                    if (rootIdx != rootPos) {
                        root[rootIdx] = rootPos;
                        --island;
                    }
                }
            }
            res.push_back(island);
        }
        return res;
    }
};