package JavaAnswer.six;

import java.util.HashMap;
import java.util.Map;

public class Solution535 {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, String> map = new HashMap<>();
    int count = 0;

    public String getSuffix(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(alphabet.charAt(n % 62));
            n /= 62;
        }
        return sb.toString();
    }

    public String encode(String longUrl) {
        count++;
        String key = getSuffix(count);
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}
