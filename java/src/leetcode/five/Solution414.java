package JavaAnswer.five;

public class Solution414 {
    public int thirdMax(int[] nums) {
        Integer largest = null;
        Integer second = null;
        Integer third = null;
        for (Integer num : nums) {
            if (num.equals(largest) || num.equals(second) || num.equals(third)) {
                continue;
            }
            if (largest == null || num > largest) {
                third = second;
                second = largest;
                largest = num;
            }
            else if (second == null || num > second) {
                third = second;
                second = num;
            }
            else if (third == null || num > third) {
                third = num;
            }
        }
        return third == null ? largest : third;
    }
}