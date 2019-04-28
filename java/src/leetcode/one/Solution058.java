package JavaAnswer.one;

public class Solution058 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }
}

class Solution058addtional {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0, j = s.length() - 1;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }
        while (j >= 0 && s.charAt(j) != ' ') {
            j--;
            res++;
        }
        return res;
    }
}