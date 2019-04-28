package interview;

/* Sort k colors
 *
 * 想法是将（0,1，。。。，k-1） category 分成（0）--> L, (1, k-2) -->M, (k-1) --> H，
 * 然后相同的思想继续call之前的function，
 * 然后reduce为 （1，k-2）的range，重复之前的事情
 * 之前的sortCategory也可以处理只有两种Category的case，不用担心， 直接call
 *
 * time: roughly O(n), since every iteration the range between start and end has shrink by 2n/k,
 * (assume colors are quite average), if the average number of each colors is close to 1, then the
 * time would be near O(n^2), we could just sort the colors to make the time O(nlgn)
 *
 * space: O(1)
 *
 * */
public class SortKColorsII {
    // 用两个全局变量来存下一次call helper method的start和end的位置，注意要先在主方法中改一下end的值
    static int start = 0, end = Integer.MAX_VALUE;

    public static void sortKColors(int[] nums, int k) {
        end = nums.length - 1;
        int color1 = 0, color2 = k - 1;
        while (start < end) {
            helper(nums, color1, color2);
            color1++;
            color2--;
        }
    }

    private static void helper(int[] nums, int color1, int color2) {
        int index = start;
        while (index < end) {
            if (nums[index] == color1) {
                nums[index] = nums[start];
                nums[start] = color1;
                start++;
            } else if (nums[index] == color2) {
                nums[index] = nums[end];
                nums[end] = color2;
                end--;
                // since the value of nums[end] is not guaranteed (could be like 2)
                // and index is before end，所以需要index--，重新扫这一个位置
                // 这里有可能会被问！
                index--;
            }
            index++;
        }
    }
}

// 给定一个API getCategory(int n)， return{L|M|H}三种category
// 第一问---给定一个Array， [4,2,5,7,8,9],对于每一个int，有一个category，sort them by category
//class SortByCategory {
//    public void sortByCategory(int[] nums) {
//        int l = 0, h = nums.length - 1, i = 0;
//        while (i <= h) {
//            if (getCategory(nums[i]) == 'L')
//                swap(nums, i++, l++);
//            else if (getCategory(nums[i]) == 'R')
//                swap(nums, i, r--);
//            else i++;
//        }
//    }
//    private void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//}


//   如果这个时候有K个category， 应该怎么办？
//   顺着上一题的思路，我的想法是将（0,1，。。。，k-1） category 分成（0）-->L,(1,k-2)-->M,(k-1)-->H， 然后相同的思想继续call之前的function，
//   然后reduce为 （1，k-2）的range，重复之前的事情
//   之前的sortCategory也可以处理只有两种Category的case，不用担心， 直接call
//   注意:为什么不要increase i,会问你的!!!!!!
//class SortKCategory {
//    public void sortKCategory(int[] nums, int k) {
//        if (nums == null || k <= 0) return;
//        int categStart = 0, categEnd = k - 1;
//        while (categStart < categEnd) // stop when only 2-3 categories left
//            sortCategory(nums, categStart++, categEnd--);
//    }
//
//    private void sortCategory(int[] nums, int l, int h) {
//        if (nums == null) return;
//        int start = 0, end = nums.length - 1;
//        while (getCategory(nums[start]) < l) start++;
//        while (getCategory(nums[end]) > h) end--;
//        int i = start; //注意loop条件
//        while (i <= end) {
//            if (getCategory(nums[i]) == l)
//                swap(nums, i++, l++); //注意为什么要increase i
//            else if (getCategory(nums[i]) == r)
//                swap(nums, i, r--); //注意为什么不要increase i, 会问你的!!!!!!
//            else i++;
//        }
//    }
//    private void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//}
