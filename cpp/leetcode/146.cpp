class LRUCache{
public:
    LRUCache(int capacity) {
        size = capacity;
    }
    
    int get(int key) {
        if(map.find(key) == map.end()) return -1;
        auto it = map[key];
        data.splice(data.begin(), data, it);
        return it->second;
    }
    
    void set(int key, int value) {
        if(map.find(key) != map.end()) data.erase(map[key]);
        data.push_front(make_pair(key, value));
        map[key] = data.begin();
        if(map.size() > size){
            int key = data.back().first;
            map.erase(key);
            data.pop_back();
        }
    }
private:
    int size = size;
    list<pair<int, int>> data;
    unordered_map<int, list<pair<int, int>>:: iterator> map;
};