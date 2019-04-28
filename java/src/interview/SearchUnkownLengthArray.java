package interview;

public class SearchUnkownLengthArray {
    public int getIndex(int[] arr, int num) {
        int idx = 0, exp = 0;
        while (true) {
            if (arr[idx] == num) {
                return idx;
            }
            else if (arr[idx] > num) {
                idx = (int) Math.pow(2, exp++);
            }
            else {
                break;
            }

            int left = idx / 2 + 1, right = idx - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == num) {
                    return mid;
                }
                else if (arr[mid] < num) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
