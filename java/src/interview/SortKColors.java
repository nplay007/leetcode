package interview;

public class SortKColors {
    //Bacic idea: bucket sort O(n) O (k)
    // Improved O(n), O(1)
    // 1. 从左扫描到右边，遇到一个数字，先找到对应的bucket.比如 3 2 2 1 4 第一个3对应的bucket是index = 2 (bucket从0开始计算）
    // 2. Bucket 如果有数字，则把这个数字移动到i的position(就是存放起来），然后把bucket记为-1(表示该位置是一个计数器，计1）。
    // 3. Bucket 存的是负数，表示这个bucket已经是计数器，直接减1. 并把color[i] 设置为0 （表示此处已经计算过）
    // 4. Bucket 存的是0，与3一样处理，将bucket设置为-1， 并把color[i] 设置为0 （表示此处已经计算过）
    // 5. 回到position i，再判断此处是否为0（只要不是为0，就一直重复2-4的步骤）。
    // 6. 完成1-5的步骤后，从尾部到头部将数组置结果。（从尾至头是为了避免开头的计数器被覆盖）

    public void sortColors2(int[] colors, int k) {
        if (colors == null) {
            return;
        }
        int len = colors.length;
        for (int i = 0; i < len; i++) {
            // Means need to deal with A[i]
            while (colors[i] > 0) {
                int num = colors[i];
                if (colors[num - 1] > 0) {
                    // 1. There is a number in the bucket,
                    // Store the number in the bucket in position i;
                    colors[i] = colors[num - 1];
                    colors[num - 1] = -1;
                }
                else if (colors[num - 1] <= 0) {
                    // 2. Bucket is using or the bucket is empty.
                    colors[num - 1]--;
                    // delete the A[i];
                    colors[i] = 0;
                }
            }
        }
        int index = len - 1;
        for (int i = k - 1; i >= 0; i--) {
            int cnt = -colors[i];
            // Empty number.
            if (cnt == 0) {
                continue;
            }
            while (cnt > 0) {
                colors[index--] = i + 1;
                cnt--;
            }
        }
    }
}
