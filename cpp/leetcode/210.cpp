class Solution {
public:
    vector<int> findOrder(int numCourses, vector<pair<int, int>>& prerequisites) {
        vector<unordered_set<int>> graph(numCourses);
        vector<int> degrees(numCourses, 0);
        queue<int> zeros;
        vector<int> res;
        for(auto pre: prerequisites) graph[pre.second].insert(pre.first);
        for (auto v : graph)
            for (int neigh : v) degrees[neigh]++
        for (int i = 0; i < numCourses; i++)
            if (!degrees[i]) zeros.push(i);
        for (int i = 0; i < numCourses; i++) {
            if (zeros.empty()) return {};
            int node = zeros.front();
            zeros.pop();
            res.push_back(node);
            for (int neigh : graph[node]) {
                if (!--degrees[neigh]) zeros.push(neigh);
            }
        }
        return res;
    }
};



//DFS
class Solution {
public:
    vector<int> findOrder(int num, vector<pair<int, int>>& pres) {
        unordered_map<int, unordered_set<int>> graph;
        vector<int> visit(num, 0);
        vector<int> res;
        for(auto pre : pres){
            graph[pre.second].insert(pre.first);
        }
        for(int i = 0; i < num; i++){
            if(!dfs(i, graph, visit, res)) return {};
        }
        reverse(res.begin(), res.end());
        return res;
    }
    
    bool dfs(int i, unordered_map<int, unordered_set<int>> &graph, vector<int> &visit, vector<int> &res){
        if(visit[i] == 1) return true;
        if(visit[i] == -1) return false;
        visit[i] = -1;
        for(auto j : graph[i]){
            if(!dfs(j, graph, visit, res)) return false;
        }
        res.push_back(i);
        visit[i] = 1;
        return true;
    }
};