package JavaAnswer.four;

public class Solution388 {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int res = 0;
        for (String path : paths) {
            int lev = path.lastIndexOf("\t") + 1;
            stack[lev + 1] = stack[lev] + path.length() - lev + 1;
            int curLen = stack[lev + 1];
            if (path.contains(".")) {
                res = Math.max(res, curLen - 1);
            }
        }
        return res;
    }
}