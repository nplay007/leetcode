package interview;
/*
 * Mine Sweeper
 * Create m boobs in Mine Sweeper with height h and width w with same probability.
 * time: O(n)
 * */

import java.util.Random;

public class mineSweeper {
    // reservoir sampling
    public int[][] getBombs(int h, int w, int m) {
        Random random = new Random();
        int[] bombsLocation = new int[m];
        // if h * w < m
        for (int i = 0; i < m; i++) {
            bombsLocation[i] = i;
        }
        for (int i = m; i < h * w; i++) {
            int j = random.nextInt(i + 1);
            if (j < m) {
                bombsLocation[j] = i;
            }
        }
        int[][] res = new int[h][w];
        for (int i = 0; i < bombsLocation.length; i++) {
            int x = bombsLocation[i] / w;
            int y = bombsLocation[i] % w;
            res[x][y] = 1;
        }
        return res;
    }
}
