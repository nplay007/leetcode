class Solution {
public:
    int totalNQueens(int n) {
     int res = 0;
     vector<int> col(n, -1);
     dfs(0, n, col, res);
     return res;
    }
    
    void dfs(int start, int n, vector<int> &col, int &res){
        if(start == n){
            res++;
            return;
        }
        for(int i = 0; i < n; i++){// i is column number 
            if(check(start, i, col)){
                col[start] = i;
                dfs(start + 1, n, col, res);
                col[start] = -1;
            }
        }
    }
    
    bool check(int i, int j, vector<int> &col){
        for(int k = 0; k < i; k++){
            if(col[k] == j || abs(k - i) == abs(col[k] - j)) return false;
        }
        return true;
    }
};