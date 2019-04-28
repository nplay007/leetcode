package JavaAnswer.six;

import JavaAnswer.TreeNode;

public class Solution536 {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int idx = s.indexOf("(");
        int val = idx == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, idx));
        TreeNode root = new TreeNode(val);
        if (idx == -1) {
            return root;
        }
        int start = idx, count = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            else if (s.charAt(i) == ')') {
                count--;
            }
            if (count == 0 && start == idx) {
                root.left = str2tree(s.substring(start + 1, i));
                start = i + 1;
            }
            else if (count == 0) {
                root.right = str2tree(s.substring(start + 1, i));
            }
        }
        return root;
    }
}
