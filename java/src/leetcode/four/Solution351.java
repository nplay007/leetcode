package JavaAnswer.four;

public class Solution351 {
    // cur: the current position
    // remain: the steps remaining
    int dfs(boolean visited[], int[][] skip, int cur, int remain) {
        if (remain < 0) {
            return 0;
        }
        else if (remain == 0) {
            return 1;
        }
        visited[cur] = true;
        int count = 0;
        for (int i = 1; i <= 9; ++i) {
            // two numbers are adjacent or skip number is already visited
            if (!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]])) {
                count += dfs(visited, skip, i, remain - 1);
            }
        }
        visited[cur] = false;
        return count;
    }

    public int numberOfPatterns(int m, int n) {
        // Skip array represents the number to skip between two pairs
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = 5;
        skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean visited[] = new boolean[10];
        int result = 0;
        for (int i = m; i <= n; ++i) {
            result += dfs(visited, skip, 1, i - 1) * 4; // 1, 3, 7, 9 are symmetric
            result += dfs(visited, skip, 2, i - 1) * 4; // 2, 4, 6, 8 are symmetric
            result += dfs(visited, skip, 5, i - 1); // 5
        }
        return result;
    }
}