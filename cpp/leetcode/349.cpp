class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> map(nums1.begin(), nums1.end());
        vector<int> res;
        for(int num: nums2){
        	if(map.count(num)){
        		res.push_back(num);
        		map.erase(num);
        	}
        }
        return res;
    }
};