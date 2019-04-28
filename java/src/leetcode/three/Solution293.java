package JavaAnswer.three;

import java.util.ArrayList;
import java.util.List;

public class Solution293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith("++", i)) {
                list.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return list;
    }
}