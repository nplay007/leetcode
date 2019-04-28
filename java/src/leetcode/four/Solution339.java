package JavaAnswer.four;

import java.util.List;

import JavaAnswer.NestedInteger;

public class Solution339 {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int depth) {
        int res = 0;
        for (NestedInteger nInt : list) {
            res += nInt.isInteger() ? nInt.getInteger() * depth : helper(nInt.getList(), depth + 1);
        }
        return res;
    }
}