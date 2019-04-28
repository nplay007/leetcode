class Solution {
public:
    int countComponents(int n, vector<pair<int, int>>& edges) {
        vector<int> root(n);
        iota(root.begin(), root.end(), 0);
        for (auto edge : edges) {
            int v = edge.first, w = edge.second;
            while (root[v] != v) v = root[v];
            while (root[w] != w) w = root[w];
            root[v] = w;
            n -= v != w;
        }
        return n;
    }
};