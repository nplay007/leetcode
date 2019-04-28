class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<pair<int, int>> &edges) {
        if (n == 1) {
            return {0};
        }
        unordered_map<int, unordered_set<int>> graph(n);
        for (auto edge : edges) {
            graph[edge.first].insert(edge.second);
            graph[edge.second].insert(edge.first);
        }
        vector<int> leaves, newLeaves;
        for (auto it : graph) {
            if (it.second.size() == 1) {
                leaves.push_back(it.first);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            newLeaves.clear();
            for (int i = 0; i < leaves.size(); i++) {
                int node = *graph[leaves[i]].begin();
                graph.erase(leaves[i]);
                graph[node].erase(leaves[i]);
                if (graph[node].size() == 1) {
                    newLeaves.push_back(node);
                }
            }
            swap(leaves, newLeaves);
        }
        return leaves;
    }
};