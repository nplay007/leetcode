package JavaAnswer.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution267 {
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        // build character count map and count odds
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            odd += map.get(ch) % 2 != 0 ? 1 : -1;
        }
        if (odd > 1) {
            return res;
        }
        // add half count of each character to list
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) {
                mid += key;
            }
            for (int i = 0; i < val / 2; i++) {
                list.add(key);
            }
        }
        // step 3. generate all the permutations
        dfs(list, mid, new boolean[list.size()], new StringBuilder(), res);
        return res;
    }

    // generate all unique permutation from list
    void dfs(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                dfs(list, mid, used, sb, res);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}