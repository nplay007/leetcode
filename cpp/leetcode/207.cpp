class Solution {
public:
    bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
        vector<unordered_set<int>> graph(numCourses);
        vector<int> degrees(numCourses, 0);
        for(auto pre:prerequisites){
            graph[pre.second].insert(pre.first);
        }
        for (auto vertex : graph)
            for (int neigh : vertex) degrees[neigh]++; // degrees >= 0
        for (int i = 0; i < numCourses; i++) {//visit one node each time
            int j = 0;
            for (; j < numCourses; j++)
                if (!degrees[j]) break; // find first no income node
            if (j == numCourses) return false; 
            // error for all node has income
            degrees[j] = -1; // visited
            for (int neigh : graph[j]) degrees[neigh]--;
        }
        return true;
    }
}; 




class Solution {
public:
    bool canFinish(int num, vector<pair<int, int>>& pres) {
        unordered_map<int, unordered_set<int>> graph;
        vector<int> visit(num, 0);
        for(auto pre : pres){
            graph[pre.second].insert(pre.first);
        }
        for(int i = 0; i < num; i++){
            if(!dfs(i, graph, visit)) return false;
        }
        return true;
    }
    
    bool dfs(int i, unordered_map<int, unordered_set<int>> &graph, vector<int> &visit ){
        if(visit[i] == 1) return true;
        else if(visit[i] == -1) return false;
        visit[i] = -1;
        for(auto j : graph[i]){
            if(!dfs(j, graph, visit)) return false;
        }
        visit[i] = 1;
        return true;
    }
};