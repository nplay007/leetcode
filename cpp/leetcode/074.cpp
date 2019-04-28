class Solution {
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target) {
        int m = matrix.size(), n = matrix[0].size();
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int idx = (r - l) / 2 + l;
            int x = idx / n;
            int y = idx % n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                r = idx - 1;
            } else {
                l = idx + 1;
            }
        }
        return false;
    }
};