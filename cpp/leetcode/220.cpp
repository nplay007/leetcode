bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
    set<int> window; 
    for (int i = 0; i < nums.size(); i++) {
        if (i > k) window.erase(nums[i-k-1]); 
        auto pos = window.lower_bound(nums[i] - t);
        if (pos != window.end() && *pos - nums[i] <= t) return true;
        window.insert(nums[i]);
    }
    return false;
}


class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
        int n = nums.size();
        if(n < 2 || k < 1 || t < 0) return false;
        unordered_map<long long, long long> buckets;
        long long width = (long long) t + 1;
        for(int i = 0; i < n; i++){
            long long id = getId(nums[i], width);
            if(buckets.find(id) != buckets.end()) return true;
            if(buckets.find(id-1) != buckets.end() && nums[i] - buckets[id-1] < width) return true;
            if(buckets.find(id+1) != buckets.end() && buckets[id+1] - nums[i] < width) return true;
            buckets[id] = nums[i];
            if(i >= k) buckets.erase(getId(nums[i-k],width));
        }
        return false;
    }
private:
    long long getId(long long i, long long w){
        return i < 0 ? (i + 1)/w-1 : i/w;
    }
};