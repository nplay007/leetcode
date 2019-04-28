class Solution {
public:
    int strobogrammaticInRange(string low, string high) {
        int res = 0;
        find(low, high, "", res);
        find(low, high, "0", res);
        find(low, high, "1", res);
        find(low, high, "8", res);
        return res;
    }
    void find(string low, string high, string w, int &res) {
        int m = low.size, n = high.size(), l = w.size();
        if (l >= m && l <= n) {
            if ((l == m && w.compare(low) < 0) || (l == n && w.compare(high) > 0)) {
                return;
            }
            if (!(w.size() > 1 && w[0] == '0')) ++res;
        }
        if (w.size() + 2 > high.size()) return;
        find(low, high, "0" + w + "0", res);
        find(low, high, "1" + w + "1", res);
        find(low, high, "6" + w + "9", res);
        find(low, high, "8" + w + "8", res);
        find(low, high, "9" + w + "6", res);
    }
};