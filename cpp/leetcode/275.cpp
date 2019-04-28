class Solution {
public:
    int hIndex(vector<int>& citations) {
        int l = 0, n = citations.size(), r = len-1,  mid;
        while(l <= r) {
            mid = l + (r - l)/2;
            if(citations[mid] >= (n - mid)) r = mid - 1;
            else l = mid + 1;
        }
        return len - l;
    }
};