class Vector2D {
public:
    Vector2D(vector<vector<int>>& vec2d) {
        start = vec2d.begin();
        end = vec2d.end();
        i = 0;
    }

    int next() {
        if(hasNext()) return (*start)[i++];
        return -1;
    }

    bool hasNext() {
        while(start != end && i == (*start).size()){
            start++;
            i = 0;
        }
        return start != end;
    }
private:
    vector<vector<int>>::iterator start, end;
    int i;
};