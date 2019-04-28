package JavaAnswer.three;

import java.util.LinkedList;
import java.util.Queue;

public class Solution286 {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] { i, j });
                }
            }
        }
        int level = 0;
        int INF = Integer.MAX_VALUE;
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] room = queue.poll();
                for (int[] dir : dirs) {
                    int x = room[0] + dir[0];
                    int y = room[1] + dir[1];
                    if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] != INF) {
                        continue;
                    }
                    queue.add(new int[] { x, y });
                    rooms[x][y] = level;
                }
            }
        }
    }
}