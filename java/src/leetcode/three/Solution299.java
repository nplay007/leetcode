package JavaAnswer.three;

import java.util.HashMap;
import java.util.Map;

public class Solution299 {
    public String getHint(String secret, String guess) {
        int[] words = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char chOfs = secret.charAt(i);
            char chOfg = guess.charAt(i);
            if (chOfs == chOfg) {
                bulls++;
            }
            else {
                if (words[chOfs - '0']++ < 0) {
                    cows++;
                }
                if (words[chOfg - '0']-- > 0) {
                    cows++;
                }
            }
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}

class Solution299II {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> gMap = new HashMap<>();
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char chOfs = secret.charAt(i);
            char chOfg = guess.charAt(i);
            if (chOfs == chOfg) {
                bulls++;
            }
            else {
                if (sMap.getOrDefault(chOfg, 0) > 0) {
                    sMap.put(chOfg, sMap.get(chOfg) - 1);
                    cows++;
                }
                else {
                    gMap.put(chOfg, gMap.getOrDefault(chOfg, 0) + 1);
                }
                if (gMap.getOrDefault(chOfs, 0) > 0) {
                    gMap.put(chOfs, gMap.get(chOfs) - 1);
                    cows++;
                }
                else {
                    sMap.put(chOfs, sMap.getOrDefault(chOfs, 0) + 1);
                }
            }
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}