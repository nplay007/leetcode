package JavaAnswer.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, List<Double>> valuesGraph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String x = equations[i][0], y = equations[i][1];
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<String>());
                valuesGraph.put(x, new ArrayList<Double>());
            }
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<String>());
                valuesGraph.put(y, new ArrayList<Double>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
            valuesGraph.get(x).add(values[i]);
            valuesGraph.get(y).add(1 / values[i]);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = dfs(queries[i][0], queries[i][1], graph, valuesGraph, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) {
                result[i] = -1.0;
            }
        }
        return result;
    }

    private double dfs(String start, String end, Map<String, List<String>> pairs, Map<String, List<Double>> values, Set<String> set,
            double value) {
        if (set.contains(start)) {
            return 0.0;
        }
        if (!pairs.containsKey(start)) {
            return 0.0;
        }
        if (start.equals(end)) {
            return value;
        }
        set.add(start);
        List<String> strList = pairs.get(start);
        List<Double> valueList = values.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pairs, values, set, value * valueList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }
        set.remove(start);
        return tmp;
    }
}
