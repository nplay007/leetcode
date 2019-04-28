class Solution {
public:
    int findMinArrowShots(vector<pair<int, int>> &points) {
        sort(points.begin(), points.end(), [](pair<int, int> a, pair<int, int> b) { return a.second < b.second; });
        long long res = 0, end = LONG_MIN;
        for (auto point : points) {
            if (point.first > end) {
                res++;
                end = point.second;
            }
        }
        return res;
    }
};