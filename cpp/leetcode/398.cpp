class Solution {
public:
    Solution(vector<int> nums) {
        data = nums;
    }

    int pick(int target) {
        int res =, cnts = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data[i] == target) {
                cnts++;
                int j = rand() % cnts;
                if (j == 0) {
                    res = i;
                }
            }
        }
        return res;
    }

private:
    vector<int> data;
};