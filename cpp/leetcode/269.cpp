class Solution {
public:
    bool dfs(unordered_map<char, unordered_set<char>>& graph, unordered_set<char>& visited, unordered_set<char>& res, string& order, char n) {
        if (res.count(n)) return false;
        if (visited.count(n)) return true;
        visited.insert(n);
        res.insert(n);
        for (auto ch : graph[n]){
            if (!dfs(graph, visited, res, order, ch)) return false;
		}
        res.erase(n);
        order += string(1, n);
        return true;
    }

    string topsort(unordered_map<char, unordered_set<char>>& graph) {
        unordered_set<char> visited; // visited
        unordered_set<char> res; // visiting 
        string order;
        for (auto it : graph) {
			if (!dfs(graph, visited, res, order, it.first)) return "";
        }
        reverse(order.begin(), order.end());
        return order;
    }

    string alienOrder(vector<string>& words) {
        if (words.size() == 1) return words.front();
        unordered_map<char, unordered_set<char>> graph;
        for (int i = 1; i < words.size(); i++) {
            string t1 = words[i - 1];
            string t2 = words[i];			
            bool found = false;
            for (int j = 0; j < max(t1.length(), t2.length()); j++) {
                if (j < t1.length() && graph.count(t1[j]) == 0)
                    graph.insert(make_pair(t1[j], unordered_set<char>()));
                if (j < t2.length() && graph.count(t2[j]) == 0)
                    graph.insert(make_pair(t2[j], unordered_set<char>()));
                if (j < t1.length() && j < t2.length() && t1[j] != t2[j] && !found) {
                    graph[t1[j]].insert(t2[j]);
                    found = true;
                }
            }
        }
        return topsort(graph);
    }
};