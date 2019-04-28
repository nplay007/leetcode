package JavaAnswer.four;

public class Solution344 {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char temp = word[left];
            word[left++] = word[right];
            word[right--] = temp;
        }
        return new String(word);
    }
}