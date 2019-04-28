package JavaAnswer.two;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex <= 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(1); // i == 0
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
            result.add(1); // j == i
        }
        return result;
    }
}