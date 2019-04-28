class TwoSum {
    unordered_map<int,int> map;
public:
    void add(int number) {
        map[number]++;
    }

    bool find(int value) {
        for (auto it : map) {
            int i = it.first;
            int j = value - i;
            if ((i == j && it.second > 1) || (i != j && map.find(j) != map.end())) {
                return true;
            }
        }
        return false;
    }
};