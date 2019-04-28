package JavaAnswer.one;

public class Solution042 {
    public int trap(int[] heights) {
        int total = 0, pill = 0, height = 0;
        int left = 0, right = heights.length - 1;
        while (left <= right) {
            int lowerSide = Math.min(heights[left], heights[right]);
            total += lowerSide > height ? (right - left + 1) * (lowerSide - height) : 0;
            height = Math.max(height, lowerSide);
            pill += heights[left] < heights[right] ? heights[left++] : heights[right--];
        }
        return total - pill;
    }
}

class Solution042II {
    public int trap(int[] heights) {
        // two pointers
        int start = 0, end = heights.length - 1;
        int result = 0, leftmax = 0, rightmax = 0;

        while (start <= end) {
            leftmax = Math.max(leftmax, heights[start]);
            rightmax = Math.max(rightmax, heights[end]);
            // if leftmax < rightmax, so the (leftmax-height[start]) water can be stored
            if (leftmax < rightmax) {
                result += (leftmax - heights[start]);
                start++;
            }
            else {
                result += (rightmax - heights[end]);
                end--;
            }
        }
        return result;
    }
}