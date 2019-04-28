class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
     int pivot = rand()%nums.size();
     vector<int> num1, num2;
     for(int i = 0; i < nums.size(); i++){
         if(nums[i] > nums[pivot]) num1.push_back(nums[i]);
         else if (nums[i] < nums[pivot]) num2.push_back(nums[i]);
     }
     if(k <= num1.size()) return findKthLargest(num1, k);
     if(k > nums.size() - num2.size()) return findKthLargest(num2, k - (nums.size() - num2.size()));
     return nums[pivot];
    }
};



class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq(nums.begin(), nums.end());
        for (int i = 0; i < k - 1; i++)
            pq.pop(); 
        return pq.top();
    }
};