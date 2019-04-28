package JavaAnswer.four;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution317 {
    class Tuple {
        public int x;
        public int y;
        public int dist;

        public Tuple(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int shortestDistance(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        List<Tuple> buildings = new ArrayList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    buildings.add(new Tuple(i, j, 0));
                }
                grid[i][j] = -grid[i][j];
            }
        }
        for (int i = 0; i < buildings.size(); ++i) { // index of building candidates
            bfs(i, buildings.get(i), dist, grid);
        }
        // Find the minimum distance
        int ans = -1;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == buildings.size() && (ans < 0 || dist[i][j] < ans)) {
                    ans = dist[i][j];
                }
            }
        }
        return ans;
    }

    public void bfs(int start, Tuple root, int[][] dist, int[][] grid) {
        Queue<Tuple> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            Tuple building = deque.poll();
            dist[building.x][building.y] += building.dist;
            for (int[] dir : dirs) {
                int x = building.x + dir[0];
                int y = building.y + dir[1];
                if (y >= 0 && x >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == start) {
                    grid[x][y] = start + 1;
                    deque.add(new Tuple(x, y, building.dist + 1));
                }
            }
        }
    }
}