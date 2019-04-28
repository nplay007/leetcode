class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        vector<int> starts, ends;
        for(auto it : intervals){
            starts.push_back(it.start);
            ends.push_back(it.end);
        }
        sort(starts.begin(), starts.end());
        sort(ends.begin(), ends.end());
        int total = 0, exist = 0;
        int i = 0, j = 0;
        while(i < starts.size() && j < starts.size()){
            if(starts[i] < ends[j]){
                if(exist > 0) exist--;
                else total++;
                i++;
            } else {
                exist++;
                j++;
            }
        }
        return total;
    }
};