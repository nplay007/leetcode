bool isReflected(vector<pair<int, int>>& points) {
    int len = points.size();
    if (len==0 || len==1) return true;
    
    unordered_map<int, set<int>> mp;
    int max = points[0].first, min = points[0].first;
    // build the map, find min and max
    for (int i=0; i<len; ++i) {
        if (points[i].first < min) min = points[i].first;
        if (points[i].first > max) max = points[i].first;
        mp[points[i].second].insert(points[i].first);
    }
    double line = (min + max) / 2.0;
    
    // mirror the sorted x value in the set using two pointer
    for (auto it = mp.begin(); it!=mp.end(); ++it) {
        set<int>& s = it->second;
        for (auto start=s.begin(), end = s.end(); start!=end; ++start) {
            if ((*start + *(--end)) / 2.0 != line)
                return false;
            if (start==end) break;
        }
    }
    return true;
}