package JavaAnswer.three;

public class Solution275 {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (citations.length - mid > citations[mid]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return citations.length - left;
    }
}