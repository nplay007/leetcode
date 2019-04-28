package JavaAnswer.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                if (!map.containsKey(ppid.get(i))) {
                    map.put(ppid.get(i), new ArrayList<>());
                }
                map.get(ppid.get(i)).add(pid.get(i));
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int pidOfKill = queue.remove();
            res.add(pidOfKill);
            if (map.containsKey(pidOfKill)) {
                for (int id : map.get(pidOfKill)) {
                    queue.add(id);
                }
            }
        }
        return res;
    }
}