package JavaAnswer.five;

import java.util.PriorityQueue;

public class Solution499 {
    class Point implements Comparable<Point> {
        int x;
        int y;
        int l;
        String s;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            l = Integer.MAX_VALUE;
            s = "";
        }

        public Point(int x, int y, int l, String s) {
            this.x = x;
            this.y = y;
            this.l = l;
            this.s = s;
        }

        @Override
        public int compareTo(Point p) {
            return l == p.l ? s.compareTo(p.s) : l - p.l;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        Point[][] points = new Point[m][n];
        for (int i = 0; i < m * n; i++) {
            points[i / n][i % n] = new Point(i / n, i % n);
        }
        int[][] dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        String[] ds = new String[] { "u", "r", "d", "l" };
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(ball[0], ball[1], 0, ""));
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (points[p.x][p.y].compareTo(p) <= 0) {
                continue; // if we have already found a route shorter
            }
            points[p.x][p.y] = p;
            for (int i = 0; i < 4; i++) {
                int dx = p.x;
                int dy = p.y;
                int l = p.l;
                while (dx >= 0 && dx < m && dy >= 0 && dy < n && maze[dx][dy] == 0 && (dx != hole[0] || dy != hole[1])) {
                    dx += dir[i][0];
                    dy += dir[i][1];
                    l++;
                }
                if (dx != hole[0] || dy != hole[1]) { // check the hole
                    dx -= dir[i][0];
                    dy -= dir[i][1];
                    l--;
                }
                pq.offer(new Point(dx, dy, l, p.s + ds[i]));
            }
        }
        return points[hole[0]][hole[1]].l == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].s;
    }
}
