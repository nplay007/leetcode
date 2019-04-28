package JavaAnswer.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (positions == null || positions.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int count = 0;
        int[] roots = new int[m * n];
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
        Arrays.fill(roots, -1); // -1 means '0'
        for (int[] position : positions) {
            int rootOfPosition = position[0] * n + position[1];
            roots[rootOfPosition] = rootOfPosition; // set root of current node
            count++;
            for (int[] dir : dirs) {
                int x = position[0] + dir[0];
                int y = position[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || roots[x * n + y] == -1) {
                    continue;
                }
                int rootOfNeighbour = findRoot(roots, x * n + y);
                if (rootOfPosition != rootOfNeighbour) {
                    roots[rootOfPosition] = rootOfNeighbour;
                    rootOfPosition = rootOfNeighbour; // update the current node root
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    private int findRoot(int[] roots, int id) {
        while (id != roots[id]) {
            id = roots[id];
        }
        return id;
    }
}