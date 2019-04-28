package JavaAnswer.one;

public class Solution038 {
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("1");
        while (--n > 0) {
            StringBuilder newStr = new StringBuilder("");
            for (int i = 0, count = 0; i < sb.length(); i++) {
                if (i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i + 1)) {
                    count++;
                }
                else {
                    newStr.append(++count).append(sb.charAt(i));
                    count = 0;
                }
            }
            sb = newStr;
        }
        return sb.toString();
    }
}