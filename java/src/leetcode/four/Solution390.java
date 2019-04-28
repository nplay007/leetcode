package JavaAnswer.four;

public class Solution390 {
    public int lastRemaining(int n) {
        boolean flag = true;
        int left = n, step = 1, head = 1;
        while (left > 1) {
            if (flag || left % 2 == 1) {
                head = head + step;
            }
            left = left / 2;
            step = step * 2;
            flag = !flag;
        }
        return head;
    }
}