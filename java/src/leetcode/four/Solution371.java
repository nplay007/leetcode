package JavaAnswer.four;

public class Solution371 {
    public int getSumIterative(int a, int b) {
        int carry = 0;
        while (b != 0) {
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}

class Solution371Recursion {
    public int getSumRecursive(int a, int b) {
        return (b == 0) ? a : getSumRecursive(a ^ b, (a & b) << 1);
    }
}