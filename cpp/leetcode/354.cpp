class Solution {
public:
    static bool cmp_first(const pair<int, int>& i, const pair<int, int>& j) {
        if (i.first == j.first) return i.second > j.second;
        return i.first < j.first;
    }
    int maxEnvelopes(vector<pair<int, int>>& envelopes) {
        vector<int> candidates;
        sort(envelopes.begin(), envelopes.end(), cmp_first);
        vector<int> dp;
        for (int i = 0; i < envelopes.size(); ++i) {
            auto itr = lower_bound(dp.begin(), dp.end(), envelopes[i].second);
            if (itr == dp.end()) dp.push_back(envelopes[i].second); 
            else *itr = envelopes[i].second;
        }
        return dp.size();
    }
};
