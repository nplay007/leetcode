// DFS
class Solution {
public:
    bool validTree(int n, vector<pair<int, int>>& edges) {
    vector<vector<int>> edgelists(n);
    for(auto i:edges) {
        edgelists[i.first].push_back(i.second);
        edgelists[i.second].push_back(i.first);
    }
    vector<bool> visited(n,false);
    if(hascycle(edgelists,visited,0,-1)) return false;
    for(auto i:visited)
        if(!i) return false;
    return true;
    }
    
    bool hascycle(vector<vector<int>> &edgelists,vector<bool> &visited,int cur,int parent) {
        if(visited[cur]) return true;
        visited[cur]=true;
        for(auto kid:edgelists[cur])
            if(kid!=parent&&hascycle(edgelists,visited,kid,cur))
                return true;
        return false;
    }
};



// Union Find
class Solution {
public:
    bool validTree(int n, vector<pair<int, int>>& edges) {
        vector<int> nodes(n,0);
        for(int i = 0; i < n; i++) nodes[i] = i;
        for(int i = 0; i < edges.size(); i++){
            int f = edges[i].first;
            int s = edges[i].second;
            while(nodes[f] != f) f = nodes[f];
            while(nodes[s] != s) s = nodes[s];
            if(nodes[f] == nodes[s]) return false;
            nodes[s] = f;
        }
        return edges.size() == n - 1;
    }
};