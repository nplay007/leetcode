class HitCounter {
private:
    queue<pair<int, int> >  hits; // timestamp:hits
    int cnt; // size 
public:
    HitCounter() {
        cnt = 0;
    }
    
    void hit(int timestamp) {
        // maintain the queue to get rid of the outdated hit pair 
        while(!hits.empty() && timestamp - hits.front().first >= 300 ){
            cnt -= hits.front().second;
            hits.pop();
        }
        // count the current hit:
        ++ cnt;
        if(!hits.empty() && timestamp == hits.back().first)  ++(hits.back().second);
        else    hits.push(make_pair(timestamp,1));
    }
    
    /** Return the number of hits in the past 5 minutes. */
    int getHits(int timestamp) {
        while(!hits.empty() && timestamp - hits.front().first >= 300){
            cnt -= hits.front().second;
            hits.pop();
        }
        return cnt;
    }
};