package JavaAnswer.four;

import java.util.HashMap;
import java.util.Map;

public class Solution311 {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new int[0][0];
        }
        int m = A.length, n = A[0].length, l = B[0].length;
        int[][] C = new int[m][l];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < l; j++) {
                        if (B[k][j] != 0) {
                            C[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return C;
    }
}

class Solution311II {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return null;
        }
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] C = new int[m][l];
        Map<Integer, Map<Integer, Integer>> table = new HashMap<>();

        for (int k = 0; k < n; k++) {
            table.put(k, new HashMap<>());
            for (int j = 0; j < l; j++) {
                if (B[k][j] != 0) {
                    table.get(k).put(j, B[k][j]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int k : table.get(j).keySet()) {
                        C[i][k] += A[i][j] * table.get(j).get(k);
                    }
                }
            }
        }
        return C;
    }
}
