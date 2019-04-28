package JavaAnswer.three;

import java.util.ArrayList;
import java.util.List;

class Codec {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            int idx = s.indexOf('#', i);
            int size = Integer.valueOf(s.substring(i, idx));
            res.add(s.substring(idx + 1, idx + size + 1));
            i = idx + size + 1;
        }
        return res;
    }
}