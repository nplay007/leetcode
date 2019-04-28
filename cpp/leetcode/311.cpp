class Solution {
public:
    vector<vector<int>> multiply(vector<vector<int>>& A, vector<vector<int>>& B) {
        int m = A.size(), n = B.size(), l = B[0].size();
        vector<vector<int>> C(m, vector<int>(l, 0));
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (A[i][j])
                    for (int k = 0; k < l; k++)
                      if(B[j][k]) C[i][k] += A[i][j] * B[j][k];
        return C;
    }
};
