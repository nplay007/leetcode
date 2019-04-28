package interview;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point {
    int x;
    int y;
    Point prev;
    int keys;

    public Point(int x, int y, int k, Point p) {
        this.x = x;
        this.y = y;
        this.keys = k;
        prev = p;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return this.x + "" + this.y;
    }

    public double distance(Point that) {
        return Math.sqrt((double) (x - that.x)  * (x - that.x) + (y - that.y) * (y - that.y));
    }
}

public class Maze {

    static List<Point> getShortestPath(char[][] grid) {
        if (grid.length == 0)
            return new ArrayList<Point>();
        // preprocessing to find start and end points
        int m = grid.length, n = grid[0].length;

        Point start = null, end = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '2')
                    start = new Point(i, j, 0, null);
                if (grid[i][j] == '3')
                    end = new Point(i, j, 0, null);
            }
        }
        // System.out.println("Start: " + start.toString());
        // System.out.println("End: " + end.toString());

        // bfs lookup
        int[][] visited = new int[m][n];
        Point path = null;
        Queue<Point> que = new LinkedList<Point>();
        que.offer(start);
        while (!que.isEmpty()) {
            Point p = que.poll();

            // out of boundary
            if (!isValid(p, m, n))
                continue;
            // in water
            if (grid[p.x][p.y] == '0')
                continue;
            // check the position visited or not before,
            // also need to check my current keys the same as visiting this position last time
            // if the same, just continue
            if ((visited[p.x][p.y] & 1) == 1 && ((visited[p.x][p.y] >> 1) ^ p.keys) == 0)
                continue;

            if (grid[p.x][p.y] >= 'A' && grid[p.x][p.y] <= 'Z') {
                int key = grid[p.x][p.y] - 'A';
                // i dont have the key for this door
                if ((p.keys & (1 << (key + 1))) == 0)
                    continue;
                else // have the key, use it and remove from my key chain
                    p.keys -= (1 << (key + 1));
            }

            if (grid[p.x][p.y] >= 'a' && grid[p.x][p.y] <= 'z') {
                int key = grid[p.x][p.y] - 'a';
                p.keys += (1 << key);
            }

            // found a path
            if (p.x == end.x && p.y == end.y) {
                path = p;
                break;
            }
            System.out.println("Dealing with point: " + p.toString());
            visited[p.x][p.y] = (p.keys << 1) + 1;

            // move around 4 directions
            int[] d = new int[] { 1, 0, -1, 0, 1 };
            for (int i = 0; i < 4; i++) {
                int dx = p.x + d[i];
                int dy = p.y + d[i + 1];
                que.offer(new Point(dx, dy, p.keys, p));
            }
        }

        // build the path;
        LinkedList<Point> ans = new LinkedList<Point>();
        while (path != null) {
            ans.addFirst(path);
            path = path.prev;
        }

        return ans;

    }

    // check a point out of boundary or not
    private static boolean isValid(Point p, int m, int n) {
        return p.x >= 0 && p.x < m && p.y >= 0 && p.y < n;
    }
}