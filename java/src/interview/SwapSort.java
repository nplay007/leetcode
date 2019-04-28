package interview;

// 给一个数组，至多允许swap数组里的任意两个数字一次，问是否可以通过swap实现数组排序。
// 需要先过一遍数组，找第一个大于下面的元素，如果没找到代表已经sorted返回true。
// 找到的话，找这个元素后面的最小的值，然后swap一下看之后的数字是否是sorted的。
// 这样子需要2-pass，时间O(n),不需要sort

public class SwapSort {
    public boolean swapSort(int[] nums) {
        int left = -1;
        int right = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                left = i - 1;
                break;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                right = i + 1;
                break;
            }
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}