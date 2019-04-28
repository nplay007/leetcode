class Solution {
public:
    bool verifyPreorder(vector<int>& preorder) {
        int low = INT_MIN;
        stack<int> stk;
        for(auto num : preorder){
            if(num < low) return false;
            while(!stk.empty() && num > stk.top()){
                low = stk.top();
                stk.pop();
            }
            stk.push(num);
        }
        return true;
    }
};