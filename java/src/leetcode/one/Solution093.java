package JavaAnswer.one;

import java.util.ArrayList;
import java.util.List;

public class Solution093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        for (int i = 1; i < Math.min(4, n - 2); i++) {
            for (int j = i + 1; j < Math.min(i + 4, n - 1); j++) {
                for (int k = j + 1; k < Math.min(j + 4, n); k++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j);
                    String s3 = s.substring(j, k), s4 = s.substring(k, n);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}