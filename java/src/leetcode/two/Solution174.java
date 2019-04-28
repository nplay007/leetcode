package JavaAnswer.two;

import java.util.Arrays;

public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[dungeon.length][dungeon[0].length - 1] = 1;
        dp[dungeon.length - 1][dungeon[0].length] = 1;
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}


class Solution1741D {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }
        int[] dp = new int[dungeon[0].length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[dungeon[0].length - 1] = 1;
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                dp[j] = Math.max(1, Math.min(dp[j], dp[j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0];
    }
}