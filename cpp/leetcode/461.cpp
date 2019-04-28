class Solution {
public:
    int hammingDistance(int x, int y) {
        int n = x ^ y, cnts = 0;
        while (n) {
            n &= (n - 1);
            cnts++;
        }
        return cnts;
    }
};