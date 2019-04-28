package JavaAnswer.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        Integer[] res = new Integer[n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            res[i] = num;
            if (num * 10 <= n) {
                num *= 10;
            }
            else {
                if (num >= n) {
                    num /= 10;
                }
                num++;
                while (num % 10 == 0) {
                    num /= 10;
                }
            }
        }
        return new ArrayList<Integer>(Arrays.asList(res));
    }
}