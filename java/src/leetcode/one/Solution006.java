package JavaAnswer.one;

public class Solution006 {
    public String convert(String s, int numRows) {
        if (numRows <= 0) {
            throw new IllegalArgumentException("Invalid numRows");
        }
        else if (numRows == 1) {
            return s;
        }
        StringBuilder[] listOfStrings = new StringBuilder[numRows];
        StringBuilder convertedString = new StringBuilder();
        // Initialise
        for (int i = 0; i < numRows; i++) {
            listOfStrings[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); i++) {
            int idx = i % (2 * numRows - 2);
            int j = idx < numRows ? idx : 2 * numRows - 2 - idx;
            listOfStrings[j].append(s.charAt(i));
        }
        for (StringBuilder sb : listOfStrings) {
            convertedString.append(sb);
        }
        return convertedString.toString();
    }
}