package JavaAnswer.six;

public class Solution504 {
    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
        else if (num < 7) {
            return Integer.toString(num);
        }
        return convertToBase7(num / 7) + Integer.toString(num % 7);
    }
}
