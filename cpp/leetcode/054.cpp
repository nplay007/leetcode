class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>> &matrix) {
        if (matrix.empty() || matrix[0].empty()) {
            return {};
        }
        vector<int> res;
        int m = matrix.size(), n = matrix[0].size();
        int left = 0, top = 0;
        while (top < m && left < n) {
            for (int i = left; i < n; ++i) {
                res.push_back(matrix[top][i]);
            }
            top++;
            for (int i = top; i < m; ++i) {
                res.push_back(matrix[i][n - 1]);
            }
            n--;
            if (top < m) {
                for (int i = n - 1; i > left - 1; --i) {
                    res.push_back(matrix[m - 1][i]);
                }
                m--;
            }
            if (left < n) {
                for (int i = m - 1; i > top - 1; --i) {
                    res.push_back(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
};