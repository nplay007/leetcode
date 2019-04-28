class Solution {
public:
    int minCostII(vector<vector<int>>& costs) {
        if(costs.empty() || costs[0].empty()) return 0;
        int preMin = 0, preSec = 0, preidx = -1;
        int m = costs.size(), n = costs[0].size();
        for(int i = 0; i < m; i++){
            int curMin = INT_MAX, curSec = INT_MAX, curidx = -1;
            for(int j = 0; j < n; j++){
                int x = costs[i][j];
                x += preidx != j? preMin:preSec;
                if(x < curMin){
                    curSec = curMin;
                    curMin = x;
                    curidx = j;
                } else if( x < curSec){
                    curSec = x;
                }
            }
            preMin = curMin;
            preSec = curSec;
            preidx = curidx;
        }
        return preMin;
    }
};