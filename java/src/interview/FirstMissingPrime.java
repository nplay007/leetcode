package interview;

public class FirstMissingPrime {
    /*
     * @param : an array of integer
     * @return: the first missing prime number
     */
    public int firstMissingPrime(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 2;
        }
        if (nums[0] != 2) {
            return 2;
        }
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1]) > 2) {
                int cur = nums[i - 1] + (nums[i - 1] % 2 == 0 ? 1 : 2);
                while (cur < nums[i]) {
                    if (isPrime(cur)) {
                        return cur;
                    }
                    cur += 2;
                }
            }
        }
        int start = nums[nums.length - 1] + 2;
        while (true) {
            if (isPrime(start)) {
                return start;
            }
            else {
                start += 2;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num != 2 && num % 2 == 0) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        int upper = (int) Math.sqrt(num);
        for (int i = 3; i <= upper; i = i + 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}