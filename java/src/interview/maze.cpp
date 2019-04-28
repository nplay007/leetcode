#include <iostream>
#include <vector>
#include <queue>
#include <utility>
using namespace std;


struct Point{
    int x;
    int y;
    Point* prev;
    int keys; // 0-32 is enough for A-Z

    Point (int row, int col, int k, Point* p) : x(row), y(col), keys(k), prev(p){};
};


bool isValid(Point *p, int m, int n){
    return p->x >= 0 && p->x < m && p->y >= 0 && p->y < n;
}

vector<pair<int, int>>  getShortestPath(vector<vector<char>> &grid){
    if(grid.empty() || grid[0].empty()) return {};

    // find the start and end point
    int m = grid.size(), n = grid[0].size();
    Point* start = NULL, *end = NULL;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == '2')   start = new Point(i, j, 0, NULL);
            if(grid[i][j] == '3')   end   = new Point(i, j, 0, NULL);
        }
    }

    vector<vector<int>> visited(m, vector<int>(n, 0));  // visited
    Point *path = NULL;
    queue<Point*> PathQue;
    PathQue.push(start);
    while(!PathQue.empty()){
        Point *p = PathQue.front(); PathQue.pop();
        int x = p->x, y = p->y;
        if(!isValid(p, m, n)) continue;
        if(grid[x][y] == '0') continue;

        if((visited[x][y] & 1) == 1 && ((visited[x][y] >> 1) ^ p->keys) == 0) continue;

        if(grid[x][y] >= 'A' && grid[x][y] <= 'Z'){
            int key = grid[x][y] - 'A';
            if((p->keys & (1 << (key + 1))) == 0) {
                continue; // not key
            } else {
                p->keys -= (1 << (key +1));
            }
        }

        if(grid[x][y] >= 'a' && grid[x][y] <= 'z'){
            int key = grid[x][y] - 'a';
            p->keys += (1 << (key + 1));
        }

        if(x == end->x && y == end->y){
            path = p;
            break;
        }
        visited[x][y] = (p->keys << 1) + 1;
        vector<int> dp = {1, 0, -1, 0, 1};
        for(int i = 0; i < 4; i++){
            int dx = x + dp[i];
            int dy = y + dp[i+1];
            PathQue.push(new Point(dx, dy, p->keys, p));
        }
    }

        vector<pair<int,int>> res;
        while(path){
            res.insert(res.begin(), make_pair(path->x, path->y));
            path = path->prev;
        }
        return res;
}

int main() {
    // vector<vector<char>> grid =  { {'0','2', '1', '1', '1'}, {'0','1','0','0','1'}, {'0','1','0','0','3'}, {'0','1','0','0','1'},
    //                               {'0','1','1','1','1'}};
    vector<vector<char>> grid =  { {'0','2', 'a', '1', '1'}, {'0','1','0','0','A'}, {'0','1','0','0','3'}, {'0','1','0','0','1'},
                                  {'0','1','1','1','1'}};

    vector<pair<int,int>> res;
    res = getShortestPath(grid);
    for(auto item : res){
        cout << item.first << item.second << endl;
    }

    return 0;
}
