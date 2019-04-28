class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        int cnts = 1;
        int m = n, t = 0, l = 0;
        vector<vector<int>> matrix(n, vector<int>(n, 0));
        while (t < m && l < n) {
            for (int i = l; i < n; i++) {
                matrix[t][i] = cnts++;
            }
            t++;
            for (int i = t; i < m; i++) {
                matrix[i][n - 1] = cnts++;
            }
            n--;
            if (t < m) {
                for (int i = n - 1; i >= l; i--) {
                    matrix[m - 1][i] = cnts++;
                }
                m--;
            }
            if (l < n) {
                for (int i = m - 1; i >= t; i--) {
                    matrix[i][l] = cnts++;
                }
                l++;
            }
        }
        return matrix;
    }
};