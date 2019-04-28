class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if(matrix.empty() || matrix[0].empty()) return 0;
        int m = matrix.size(), n = matrix[0].size(), res = 0;
        vector<int> dp(n, 0);
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            res = max(res, dfs(dp));
        }
        return res;
    }
    
    int largestRectangleArea(vector<int>& heights) {
        heights.push_back(0);
        int res = 0;
        stack<int> stk;
        for(int i = 0; i < heights.size(); i++){
            if(stk.empty()) stk.push(i);
            while(!stk.empty() && heights[i] < heights[stk.top()]){
                int idx = stk.top(); stk.pop();
                int width = stk.empty() ? i : (i - stk.top() - 1);
                res = max(heights[idx] * width, res);
            }
            stk.push(i);
        }
        return res;
    }
};