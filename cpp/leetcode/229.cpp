class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int cnts1 = 0, cnts2 = 0;
        int nums1 = 0, nums2 = 1; // no matter the exactly value, just different
        for(auto num : nums){
            if(num == nums1){
                cnts1 ++;
            } else if (num == nums2){
                cnts2 ++;
            } else if (cnts1 == 0) {
                nums1 = num;
                cnts1 ++;
            } else if (cnts2 == 0) {
                nums2 = num;
                cnts2 ++;
            } else {
                cnts1 --;
                cnts2 --;
            }
        }
        cnts1 = 0; cnts2 = 0;
        for(auto num : nums){
            if(num == nums1) cnts1 ++;
            else if(num == nums2) cnts2++;
        }
        vector<int> res;
        if(cnts1 > nums.size() / 3)  res.push_back(nums1);
        if(cnts2 > nums.size() / 3)  res.push_back(nums2);
        return res;
    }
};