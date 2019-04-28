class Solution {
public:
    int depthSum(vector<NestedInteger> &nestedList) {
        int res = 0;
        for (auto list : nestedList) {
            res += getSum(list, 1);
        }
        return res;
    }

    int getSum(NestedInteger num, int level) {
        int res = 0;
        if (num.isInteger()) {
            return level * num.getInteger();
        }
        for (auto n : num.getList()) {
            res += getSum(n, level + 1);
        }
        return res;
    }
};

class Solution {
public:
    int depthSum(vector<NestedInteger> &nestedList) {
        return helper(nestedList, 1);
    }
    int helper(vector<NestedInteger> &nlist, int depth) {
        int res = 0;
        for (auto item : nlist) {
            res += item.isInteger() ? item.getInteger() * depth : helper(item.getList(), depth + 1);
        }
        return res;
    }
};