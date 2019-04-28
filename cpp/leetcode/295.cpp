class MedianFinder {
public:
    void addNum(int num) {
        if(dmax.size() == dmin.size()){
            dmax.push(-num);
            dmin.push(-dmax.top());
            dmax.pop();
        } else {
            dmin.push(num);
            dmax.push(-dmin.top());
            dmin.pop();
        }
    }

    double findMedian() {
        if(dmax.size() < dmin.size()){
            return dmin.top(); 
        } else {
            double d1 = -dmax.top(); 
            double d2 = dmin.top(); 
            return (d1 + d2)/2.0;
        }
    }
private:
    priority_queue<int> dmax, dmin;
};