package JavaAnswer.four;

public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] word = new int[26];
        for (char ch : magazine.toCharArray()) {
            word[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (--word[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}