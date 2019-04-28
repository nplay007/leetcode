package JavaAnswer.two;

import java.util.Arrays;

public class Solution179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
//        Comparator<String> cmp = new Comparator<String>() {
//            @Override
//            public int compare(String str1, String str2) {
//                String s1 = str1 + str2;
//                String s2 = str2 + str1;
//                return s2.compareTo(s1);
//            }
//        };
        Arrays.sort(numStr, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));
        if (numStr[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : numStr) {
            sb.append(str);
        }
        return sb.toString();
    }
}