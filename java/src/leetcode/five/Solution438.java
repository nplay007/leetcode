package JavaAnswer.five;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        int[] words = new int[256];
        for (char ch : p.toCharArray()) {
            words[ch]++;
        }
        int left = 0, right = 0, miss = p.length();
        while (right < s.length()) {
            //move right every time, if the character exists in p, decrease the count
            //current count value >= 1 means the character is existing in p
            if (words[s.charAt(right++)]-- >= 1) {
                miss--;
            }
            if (miss == 0) {
                res.add(left);
            }
            //if we find the window's size equals to p, then we have to move left to find the new match window
            //++ to reset the count because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the count, because it won't go below 0
            if (right - left == p.length() && words[s.charAt(left++)]++ >= 0) {
                miss++;
            }
        }
        return res;
    }
}
