class Solution {
public:
    unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> map;
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
       if (!node) return node;
       if(map.find(node) == map.end()) {
           map[node] = new UndirectedGraphNode(node->label);
           for (auto x : node->neighbors) {
                (map[node]->neighbors).push_back(cloneGraph(x));
           }
       }
       return map[node];
    }
};



class Solution {
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if(!node) return NULL;
        UndirectedGraphNode *nodeCopy = new UndirectedGraphNode(node->label);
        unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> map = {{node, nodeCopy}};
        queue<UndirectedGraphNode *> q;
        q.push(node);
        while(!q.empty()){
            auto node = q.front(); q.pop();
            for(auto neig : node->neighbors){
                if(map.find(neig) == map.end()){
                    auto copy = new UndirectedGraphNode(neig->label);
                    map[neig] = copy;
                    map[node]->neighbors.push_back(copy);
                    q.push(neig);
                } else {
                    map[node]->neighbors.push_back(map[neig]);
                }
            }
        }
        return nodeCopy;
    }
};