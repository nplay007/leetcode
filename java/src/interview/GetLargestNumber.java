package interview;

public class GetLargestNumber {
    public int getLargestNum(int num) {
        int[] digit = new int[10];
        while (num != 0) {
            digit[num % 10]++;
            num /= 10;
        }
        int res = 0;
        for (int i = 9; i >= -1; i--) {
            for (int j = 0; j < digit[i]; j++) {
                res = res * 10 + digit[i];
            }
        }
        return res;
    }
}
