class Solution {
public:
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