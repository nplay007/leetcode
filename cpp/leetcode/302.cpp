class Solution {
public:
    int minArea(vector<vector<char>>& image, int x, int y) {
        if(image.empty() || image[0].empty()) return 0;
        int m = image.size(), n = image[0].size();
        int top = row(0, x, 0, n, true, image);
        int bot = row(x+1, m, 0, n, false, image);
        int left = col(0, y, top, bot, true, image);
        int right = col(y + 1, n, top, bot, false, image);
        return (right - left) * (bot - top);
    }
    
    int row(int top, int bot, int left, int right, bool flag, vector<vector<char>> &image){
        while(top != bot){
            int i = left, mid = (bot - top)/2 + top;
            while(i < right && image[mid][i] == '0') i++;
            if(i < right == flag) bot = mid;
            else top = mid + 1;
        }
        return top;
    }
    
    int col(int top, int bot, int left, int right, bool flag, vector<vector<char>> &image){
        while(top != bot){
            int i = left, mid = (bot - top)/2 + top;
            while(i < right && image[i][mid] == '0') i++;
            if(i < right == flag) bot = mid;
            else top = mid + 1;
        }
        return top;
    }
};