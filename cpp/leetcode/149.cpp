class Solution {
public:
    int maxPoints(vector<Point>& points) {
        if(points.size() < 2) return points.size();
        int res = 0, n = points.size();
        for(int i = 0; i < n; i++){
            map<pair<int, int>, int> line;
            int same = 1, vert = 0; // same = 1
            for(int j = i + 1; j < n; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y) same++;
                else if(points[i].x == points[j].x) vert++;
                else{
                    int dx = points[i].x - points[j].x;
                    int dy = points[i].y - points[j].y;
                    int g = gcd(dx, dy);
                    line[make_pair(dx/g, dy/g)]++;
                }
            }
            res = max(res, vert + same);
            for(auto it : line) res = max(res, it.second + same);
        }
        return res;
    }
    
    
    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
};