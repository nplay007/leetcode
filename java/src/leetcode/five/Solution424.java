package JavaAnswer.five;

public class Solution424 {
    public int characterReplacement(String s, int k) {
        int[] count = new int[256];
        int left = 0, maxCount = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(right)]);
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left++)]--;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
