package JavaAnswer.five;

import java.util.ArrayList;
import java.util.List;

public class Solution411 {
    class Node {
        Node[] nodes;
        boolean isWord;

        Node() {
            nodes = new Node[26];
            isWord = false;
        }

        void add(String str) {
            if (str.length() == 0) {
                isWord = true;
            }
            else {
                int idx = str.charAt(0) - 'a'; // insert a new node
                if (nodes[idx] == null) {
                    nodes[idx] = new Node();
                }
                nodes[idx].add(str.substring(1));
            }
        }

        boolean isAbbr(String abbr, int num) {
            if (num > 0) { // number of '*'
                for (Node node : nodes) {
                    if (node != null && node.isAbbr(abbr, num - 1)) {
                        return true;
                    }
                }
                return false;
            }
            else {
                if (abbr.length() == 0) {
                    return isWord; // at the end of the addr
                }
                int idx = 0; // get the number of '*' at the start of the abbr
                while (idx < abbr.length() && Character.isDigit(abbr.charAt(idx))) {
                    num = (num * 10) + (abbr.charAt(idx++) - '0');
                }
                if (num > 0) {
                    return isAbbr(abbr.substring(idx), num); // start with number
                }
                else { // start with non-number
                    if (nodes[abbr.charAt(0) - 'a'] != null) {
                        return nodes[abbr.charAt(0) - 'a'].isAbbr(abbr.substring(1), 0);
                    }
                    else {
                        return false;
                    }
                }
            }
        }
    }

    // DFS with backtracking
    void dfs(char[] words, int s, int len, StringBuilder sb, List<String> abbr) {
        boolean preNum = (sb.length() > 0) && (sb.charAt(sb.length() - 1) >= '0') && (sb.charAt(sb.length() - 1) <= '9');
        if (len == 1) {
            if (s < words.length) {
                if (s == words.length - 1) {
                    abbr.add(sb.toString() + words[s]); // add one char
                }
                if (!preNum) {
                    abbr.add(sb.toString() + (words.length - s)); // add a number
                }
            }
        }
        else if (len > 1) {
            int last = sb.length();
            for (int i = s + 1; i < words.length; i++) {
                if (!preNum) { // add a number
                    sb.append(i - s);
                    dfs(words, i, len - 1, sb, abbr);
                    sb.delete(last, sb.length());
                }
                if (i == s + 1) { // add one char
                    sb.append(words[s]);
                    dfs(words, i, len - 1, sb, abbr);
                    sb.delete(last, sb.length());
                }
            }
        }
    }

    public String minAbbreviation(String target, String[] dictionary) {
        List<String> dict = new ArrayList<>();
        int len = target.length();
        for (String str : dictionary) {
            if (str.length() == len) {
                dict.add(str);
            }
        }
        if (dict.isEmpty()) {
            return "" + len;
        }
        Node root = new Node();
        for (String str : dict) {
            root.add(str);
        }
        char[] words = target.toCharArray();
        String res = null;

        int left = 1, right = len;
        while (right >= left) {
            int mid = left + ((right - left) / 2);
            List<String> abbrs = new ArrayList<>();
            dfs(words, 0, mid, new StringBuilder(), abbrs);
            boolean conflict = true;
            for (String abbr : abbrs) {
                if (!root.isAbbr(abbr, 0)) {
                    conflict = false;
                    res = abbr;
                    break;
                }
            }
            if (conflict) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return res;
    }
}
