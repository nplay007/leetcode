class Solution {
public:
    int firstBadVersion(int n) {
        int l = 0, r = n;
        while(l < r){
            int m = (r - l) / 2 + l;
            if(isBadVersion(m)) r = m;
            else l = m + 1;
        }
        return r;
    }
};