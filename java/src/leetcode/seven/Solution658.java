package JavaAnswer.seven;

import java.util.List;

public class Solution658 {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int lo = 0, hi = arr.size() - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr.get(mid) > arr.get(mid + k) - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        return arr.subList(lo, lo + k);
    }
}