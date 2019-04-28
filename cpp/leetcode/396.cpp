class Solution {
public:
    int maxRotateFunction(vector<int>& A) {
        int F = 0, total = 0;
        for(int i = 0; i < A.size(); i++){
            F += i * A[i];
            total += A[i];
        }
        int res = F, n = A.size();
        for(int i = n - 1; i >= 0; i--){
            F = F + total - n * A[i];
            res = max(res, F);
        }
        return res;
    }
};