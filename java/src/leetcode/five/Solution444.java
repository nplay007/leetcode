package JavaAnswer.five;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Queue;

public class Solution444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            if (seq.size() == 1) {
                if (!graph.containsKey(seq.get(0))) {
                    graph.put(seq.get(0), new HashSet<>());
                    indegree.put(seq.get(0), 0);
                }
            } else {
                for (int i = 0; i < seq.size() - 1; i++) {
                    if (!graph.containsKey(seq.get(i))) {
                        graph.put(seq.get(i), new HashSet<>());
                        indegree.put(seq.get(i), 0);
                    }
                    if (!graph.containsKey(seq.get(i + 1))) {
                        graph.put(seq.get(i + 1), new HashSet<>());
                        indegree.put(seq.get(i + 1), 0);
                    }
                    if (graph.get(seq.get(i)).add(seq.get(i + 1))) {
                        indegree.put(seq.get(i + 1), indegree.get(seq.get(i + 1)) + 1);
                    }
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                return false;
            }
            int node = queue.poll();
            if (index == org.length || node != org[index++]) {
                return false;
            }
            for (int next : graph.get(node)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return index == org.length && index == graph.size();
    }
}

class Solution444II {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs == null || seqs.size() == 0) {
            return false;
        }
        int[] idx = new int[org.length + 1];
        boolean[] pairs = new boolean[org.length];
        for (int i = 0; i < org.length; i++) {
            idx[org[i]] = i;
        }
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (seq.get(i) > org.length || seq.get(i) < 0) {
                    return false;
                }
                if (i > 0 && idx[seq.get(i - 1)] >= idx[seq.get(i)]) {
                    return false;
                }
                if (i > 0 && idx[seq.get(i - 1)] + 1 == idx[seq.get(i)]) {
                    pairs[idx[seq.get(i - 1)]] = true;
                }
            }
        }
        for (int i = 0; i < org.length - 1; i++) {
            if (!pairs[i]) {
                return false;
            }
        }
        return true;
    }
}
