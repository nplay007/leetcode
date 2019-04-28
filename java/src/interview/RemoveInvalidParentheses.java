package interview;

// To make the prefix valid, we need to remove a ‘)’. The problem is: which one? The answer is any one in the prefix.
// However, if we remove any one, we will generate duplicates, e.x. s = ()). Thus, we noly remove 1st ) in a series of concecutive )s.
// After the removal, the prefix is then valid. We then call the function recursively to solve the rest of the string.
// However, we need to keep another information: the last removal position. If we do not have this position, we will generate duplicates.
// For this, we keep tracking the last removal position and only remove ‘)’ after that.
// Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘? The answer is: do the same from right to left.
// However a cleverer idea is: reverse the string and reuse the code!
//Time: O(nk), k: # of recursion calls
//Run: e.x."()())()"
//// "()())()" -> "(())()" -> ")())(("
////			 -> "()()()" -> ")()()("
//// res = ["(())()", "()()()"]
//Test: 	"", // empty
//		")(", // -> ""
//		"()())()", // normal
//		"(a)())()" // contain non-parenthesis char

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, s, new char[]{'(', ')'}, 0, 0);
        return res;
    }

    private void dfs(List<String> res, String s, char[] p, int iStart, int jStart) {
        // find 1st invalid p[1]
        int stack = 0, i;
        for (i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == p[0]) stack++;
            if (s.charAt(i) == p[1]) stack--;
            // remove each (not consecutive) p[1] from jStart to i to make valid
            if (stack < 0) {
                for (int j = jStart; j <= i; j++) // <=
                    if (s.charAt(j) == p[1] && (j == jStart || s.charAt(j - 1) != p[1])) {
                        String r = s.substring(0, j) + s.substring(j + 1);
                        dfs(res, r, p, i, j);
                    }
                return; // important!!
            }
        }
        // stack >= 0 : try reverse s and re-do DFS; if already reversed, then add to res
        String reverse = new StringBuilder(s).reverse().toString();
        if (p[0] == '(')
            dfs(res, reverse, new char[]{')', '('}, 0, 0); // important: 0, 0
        else
            res.add(reverse);
    }


// 只输出第一个valid的
// Time: O(n), 2 pass
// 思路：按照判断isValid的思路，只要遇到stack<0就remove，完了之后reverse再来一次。
    public String removeInvalidI(String s) {
        String r = remove(s, new char[]{'(', ')'});
        String tmp = remove(new StringBuilder(r).reverse().toString(), new char[]{')', '('});
        return new StringBuilder(tmp).reverse().toString();
    }

    private String remove(String s, char[] p) {
        int stack = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == p[0]) {
                stack++;
            }
            if (s.charAt(i) == p[1]) {
                stack--;
            }
            if (stack < 0) {
                s = s.substring(0, i) + s.substring(i + 1);
                i--;
                stack = 0;
            }
        }
        return s;
    }

    public String removeInvalid(String input) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (stack.isEmpty() || input.charAt(stack.peek()) != '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder(input);
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
}