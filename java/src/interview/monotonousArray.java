package interview;

// 判断一个array是否单调递增或者递减：扫一遍，然后开始的时候判断头和尾巴是增还是减？

public class monotonousArray {
    public boolean isMonotonousArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        for (int i = 2; i < nums.length; i++) {
            if ((nums[i] > nums[i-1]) != (nums[i-1] > nums[i-2])) {
                return false;
            }
        }
        return nums[1] != nums[0];
    }
}
