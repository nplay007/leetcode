package JavaAnswer.two;

import java.util.HashMap;
import java.util.Map;

public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        res.append(sign).append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return res.toString();
        }
        res.append(".");
        Map<Long, Integer> hashMap = new HashMap<>();
        while (!hashMap.containsKey(remainder)) {
            hashMap.put(remainder, res.length());
            res.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        int index = hashMap.get(remainder);
        res.insert(index, "(");
        res.append(")");
        return res.toString().replace("(0)", "");
    }
}