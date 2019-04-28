package JavaAnswer.four;

public class Solution365 {
    public boolean canMeasureWater(int x, int y, int z) {
        // that water is finally in one or both buckets
        if (x + y < z) {
            return false;
        }
        // case x or y is zero
        if (x == z || y == z || x + y == z) {
            return true;
        }
        // get GCD, then we can use the property of Bézout's identity
        return z % GCD(x, y) == 0;
    }

    public int GCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}