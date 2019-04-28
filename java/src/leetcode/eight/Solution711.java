package JavaAnswer.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution711 {
    ArrayList<Integer> shape;

    public void explore(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] != 1 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        shape.add(i * grid[0].length + j);
        explore(i + 1, j, grid, visited);
        explore(i - 1, j, grid, visited);
        explore(i, j + 1, grid, visited);
        explore(i, j - 1, grid, visited);
    }

    public String canonical(ArrayList<Integer> shape, int[][] grid) {
        String ans = "";
        int lift = grid.length + grid[0].length;
        int[] out = new int[shape.size()];
        int[] xs = new int[shape.size()];
        int[] ys = new int[shape.size()];

        for (int i = 0; i < 8; ++i) {
            int t = 0;
            for (int z : shape) {
                int x = z / grid[0].length;
                int y = z % grid[0].length;
                // x y, x -y, -x y, -x -y
                // y x, y -x, -y x, -y -x
                xs[t] = i <= 1 ? x : i <= 3 ? -x : i <= 5 ? y : -y;
                ys[t++] = i <= 3 ? (i % 2 == 0 ? y : -y) : (i % 2 == 0 ? x : -x);
            }

            int mx = xs[0], my = ys[0];
            for (int x : xs) {
                mx = Math.min(mx, x);
            }
            for (int y : ys) {
                my = Math.min(my, y);
            }

            for (int j = 0; j < shape.size(); ++j) {
                out[j] = (xs[j] - mx) * lift + (ys[j] - my);
            }
            Arrays.sort(out);
            String candidate = Arrays.toString(out);
            if (ans.compareTo(candidate) < 0) {
                ans = candidate;
            }
        }
        return ans;
    }

    public int numDistinctIslands2(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> shapes = new HashSet<String>();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                shape = new ArrayList<>();
                explore(i, j, grid, visited);
                if (!shape.isEmpty()) {
                    shapes.add(canonical(shape, grid));
                }
            }
        }
        return shapes.size();
    }
}
