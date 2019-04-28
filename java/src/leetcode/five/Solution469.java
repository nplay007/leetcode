package JavaAnswer.five;

import java.util.List;

public class Solution469 {
    public boolean isConvex(List<List<Integer>> points) {
        boolean gotNegative = false;
        boolean gotPositive = false;
        int numPoints = points.size();
        int B, C;
        for (int A = 0; A < numPoints; A++) {
            B = (A + 1) % numPoints;
            C = (B + 1) % numPoints;

            int crossProduct = crossProductLength(points.get(A).get(0), points.get(A).get(1), points.get(B).get(0), points.get(B).get(1),
                    points.get(C).get(0), points.get(C).get(1));
            if (crossProduct < 0) {
                gotNegative = true;
            }
            else if (crossProduct > 0) {
                gotPositive = true;
            }
            if (gotNegative && gotPositive)
                return false;
        }
        return true;
    }

    private int crossProductLength(int Ax, int Ay, int Bx, int By, int Cx, int Cy) {
        int BAx = Ax - Bx;
        int BAy = Ay - By;
        int BCx = Cx - Bx;
        int BCy = Cy - By;
        return (BAx * BCy - BAy * BCx);
    }
}
