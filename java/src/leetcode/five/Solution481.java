package JavaAnswer.five;

public class Solution481 {
    public int magicalString(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }

        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        int head = 2, tail = 3, num = 1, result = 1;
        while (tail < n) {
            for (int i = 0; i < nums[head]; i++) {
                nums[tail] = num;
                if (num == 1 && tail < n) {
                    result++;
                }
                tail++;
            }
            num = num ^ 3;
            head++;
        }
        return result;
    }
}
