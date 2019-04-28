package JavaAnswer.five;

import java.util.ArrayList;
import java.util.List;

public class Solution401 {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount((h << 6) + m) == num) { // six digit is 6
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }
}