class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.empty() || costs[0].empty()) return 0;
        int n = costs.size();
        vector<int> pre = {costs[0][0], costs[0][1], costs[0][2]};
        vector<int> cur(3, 0);
        for(int i = 1; i < n; i++){
            cur[0] = min(pre[1], pre[2]) + costs[i][0];
            cur[1] = min(pre[0], pre[2]) + costs[i][1];
            cur[2] = min(pre[0], pre[1]) + costs[i][2];
            pre = cur;
        }
        return min(pre[0], min(pre[1], pre[2]));
    }
};