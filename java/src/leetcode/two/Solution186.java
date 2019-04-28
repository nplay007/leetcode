package JavaAnswer.two;

public class Solution186 {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) {
            return;
        }
        reverse(str, 0, str.length - 1);
        for (int i = 0, j = 0; i < str.length; i = j + 1) {
            for (j = i; j < str.length && str[j] != ' '; j++)
                ;
            reverse(str, i, j - 1);
        }
    }

    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char tmp = str[left];
            str[left++] = str[right];
            str[right--] = tmp;
        }
    }
}