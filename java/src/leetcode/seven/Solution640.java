package JavaAnswer.seven;

public class Solution640 {
    public String coeff(String s) {
        if (s.length() > 1 && s.charAt(s.length() - 2) >= '0' && s.charAt(s.length() - 2) <= '9') {
            return s.replace("x", "");
        }
        return s.replace("x", "1");
    }

    public String solveEquation(String equation) {
        String[] leftAndRight = equation.split("=");
        int leftValue = 0, rightValue = 0;
        for (String left : leftAndRight[0].split("(?=\\+)|(?=-)")) {
            if (left.indexOf("x") >= 0) {
                leftValue += Integer.parseInt(coeff(left));
            }
            else {
                rightValue -= Integer.parseInt(left);
            }
        }
        for (String right : leftAndRight[1].split("(?=\\+)|(?=-)")) {
            if (right.indexOf("x") >= 0) {
                leftValue -= Integer.parseInt(coeff(right));
            }
            else {
                rightValue += Integer.parseInt(right);
            }
        }
        if (leftValue == 0) {
            if (rightValue == 0) {
                return "Infinite solutions";
            }
            else {
                return "No solution";
            }
        }
        else {
            return "x=" + rightValue / leftValue;
        }
    }
}