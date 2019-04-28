package interview;

public class PreviousPermutation {
    public String find_prev_permutation(String s) {
        int n = s.length() - 1;
        int i = n;
        while (i > 0 && s.charAt(i - 1) <= s.charAt(i)) {
            i--;
        }

        if (i <= 0) {
            return s;
        }
        int j = i - 1;
        while (j + 1 <= n && s.charAt(j + 1) <= s.charAt(i - 1)) {
            j++;
        }
        char[] chOfs = s.toCharArray();
        char tmp = chOfs[i-1];
        chOfs[i-1] = chOfs[j];
        chOfs[j] = tmp;
        StringBuilder revS = new StringBuilder("");
        revS.append(chOfs, i, s.length() - i);
        StringBuilder res = new StringBuilder("");
        res.append(chOfs, 0, i-1).append(revS);
        return res.toString();
    }
}
