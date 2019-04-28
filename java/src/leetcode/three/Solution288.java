package JavaAnswer.three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ValidWordAbbr {
    private final Map<String, Boolean> map;
    private final Set<String> set;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        set = new HashSet<>(Arrays.asList(dictionary));
        for (String s : set) {
            String abbr = getAbbr(s);
            map.put(abbr, !map.containsKey(abbr)); // dear, door
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        Boolean hasAbbr = map.get(abbr);
        return hasAbbr == null || (hasAbbr && set.contains(word));
    }

    private String getAbbr(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }
}