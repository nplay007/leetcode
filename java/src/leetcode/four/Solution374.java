package JavaAnswer.four;

class GuessGame {
    public int guess(int start) {
        return 1;
    }
}

public class Solution374 extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            }
            else if (res == 1) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return right; // same as left - 1
    }
}
