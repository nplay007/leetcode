package interview;

public class Sort4Colors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int l = 0, r = nums.length - 1, i = 0;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, l++, i++);
            }
            else if (nums[i] == 2) {
                swap(nums, r--, i);
            }
            else {
                i++;
            }
        }
        return;
    }

    void sortColors2(int[] colors, int k) {
        int left = 0, right = colors.length - 1;
        int i = 0;
        int minColor = 0, maxColor = k - 1;
        while (minColor < maxColor) {
            while (i <= right) {
                if (colors[i] == minColor) {
                    swap(colors, left++, i++);
                }
                else if (colors[i] == maxColor) {
                    swap(colors, right--, i);
                }
                else {
                    i++;
                }
            }
            i = left;
            minColor++;
            maxColor--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
