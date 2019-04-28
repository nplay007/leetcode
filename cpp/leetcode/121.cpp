class Solution {
public:
    int resfit(vector<int> &prices) {
        int res = 0;
        int minPrice = INT_MAX;
        for (int price : prices) {
            minPrice = min(minPrice, price);
            res = max(res, price - minPrice);
        }
        return res;
    }
};