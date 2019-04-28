class cmp{
public:
    bool operator()(pair<int, int> a, pair<int, int> b){
        return a.first+a.second < b.first + b.second;
    }
};

class Solution {
public:
    vector<pair<int, int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> PQ;
        for(int i = 0; i < nums1.size(); i++){
            for(int j = 0; j < nums2.size(); j++){
                if(PQ.size() < k){
                    PQ.push(make_pair(nums1[i], nums2[j]));
                } else {
                    if(nums1[i] + nums2[j] > PQ.top().first + PQ.top().second){
                        continue;
                    } else {
                        PQ.push(make_pair(nums1[i], nums2[j]));
                        PQ.pop();
                    }
                }
            }
        }
        vector<pair<int, int>> res;
        while(!PQ.empty()){
            res.push_back(PQ.top());
            PQ.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};