package JavaAnswer.five;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution465 {
    public int minTransfers(int[][] transactions) {
        if (transactions == null || transactions.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            int x = transactions[i][0];
            int y = transactions[i][1];
            int money = transactions[i][2];
            map.put(x, map.getOrDefault(x, 0) - money);
            map.put(y, map.getOrDefault(y, 0) + money);
        }
        List<Integer> negs = new ArrayList<>();
        List<Integer> poss = new ArrayList<>();
        for (Integer key : map.keySet()) {
            int m = map.get(key);
            if (m == 0) {
                continue;
            }
            else if (m < 0) {
                negs.add(-m);
            }
            else {
                poss.add(m);
            }
        }
        int ans = Integer.MAX_VALUE;
        Stack<Integer> stNeg = new Stack<>(), stPos = new Stack<>();
        for (int i = 0; i < 1000; i++) {
            for (Integer num : negs)
                stNeg.push(num);
            for (Integer num : poss)
                stPos.push(num);
            int cur = 0;
            while (!stNeg.isEmpty()) {
                int n = stNeg.pop();
                int p = stPos.pop();
                cur++;
                if (n == p)
                    continue;
                if (n > p) {
                    stNeg.push(n - p);
                }
                else {
                    stPos.push(p - n);
                }
            }
            ans = Math.min(ans, cur);
            Collections.shuffle(negs);
            Collections.shuffle(poss);
        }
        return ans;
    }

}
