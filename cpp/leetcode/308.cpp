class Solution{
NumMatrix(vector<vector<int>> &matrix) {
    for (int i = 0; i < matrix.size(); i++) {
        vector<int> sum_row;
        int sum = 0;
        for (int j = 0; j < matrix[i].size(); j++) {
            sum += matrix[i][j];
            sum_row.push_back(sum);
        }
        sum_matrix.push_back(sum_row);
    }
}

void update(int row, int col, int val) {
    int delta = sum_matrix[row][col - 1] + val - sum_matrix[row][col];
    for (int j = col; j < sum_matrix[0].size(); j++) {
        sum_matrix[row][j] += delta;
    }
}

int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int i = row1; i <= row2; i++) {
        sum += sum_matrix[i][col2] - sum_matrix[i][col1 - 1];
    }
    return sum;
}
private:
vector<vector<int>> sum_matrix;
};