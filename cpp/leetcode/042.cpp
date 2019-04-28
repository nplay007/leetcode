class Solution {
  public:
    int trap(vector<int> &height) {
        int total = 0, pill = 0, h = 0;
        int left = 0, right = height.size() - 1;
        while (left <= right) {
            int tmp = min(height[left], height[right]);
            total += tmp > h ? (right - left + 1) * (tmp - h) : 0;
            h = max(h, tmp);
            pill += height[left] < height[right] ? height[left++] : height[right--];
        }
        return total - pill;
    }
};