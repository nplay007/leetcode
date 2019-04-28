package JavaAnswer.six;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] words = new int[256];
        for (char ch : s1.toCharArray()) {
            words[ch]++;
        }
        int left = 0, right = 0, miss = s1.length();
        while (right < s2.length()) {
            // move right every time, decrease the count
            // current count value > 0 means the character is existing in s2
            // if not exists in s2, get negative value
            if (words[s2.charAt(right++)]-- > 0) {
                miss--;
            }
            if (miss == 0) {
                return true;
            }
            // if we find the window's size equals to s2, then we have to move left to find the new match window
            // ++ to reset the count because we kicked out the left
            // only increase the count if the character is in s2
            // the count >= 0 indicate it was original in the count, because it won't go below 0
            if (right - left == s1.length() && words[s2.charAt(left++)]++ >= 0) {
                miss++;
            }
        }
        return false;
    }
}