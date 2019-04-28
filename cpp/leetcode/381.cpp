class RandomizedCollection {
public:
    RandomizedCollection() { }
    
    bool insert(int val) {
        m[val].push_back(nums.size());
        nums.push_back(make_pair(val, m[val].size() - 1));
        return m[val].size() == 1;
    }
    
    bool remove(int val) {
        auto result = m.find(val) != m.end();
        if(result) {
            int idx = m[val].back();
            m[val].pop_back();
            int last = nums.back();
            m[last.first][last.second] = idx;
            nums[idx] = last;
            if(m[val].empty()) m.erase(val);
            nums.pop_back();
        }
        return result;
    }
    
    int getRandom() {
        return nums[rand() % nums.size()].first;
    }
private:
    vector<pair<int, int>> nums;
    unordered_map<int, vector<int>> m;
};



class RandomizedCollection {
public:
    RandomizedCollection() {}
    
    bool insert(int val) {
        nums.push_back(val);
        m[val].push_back(nums.size() - 1);
        return m[val].size() == 1;
    }
    
    bool remove(int val) {
        if(m.find(val) != m.end()){
            int idx = m[val].back();
            m[val].pop_back();
            if(m[val].empty()) m.erase(val);
            if(nums.size() - 1 != idx){
                int last = nums.back();
                nums[idx] = last;
                m[last].pop_back();
                m[last].insert(m[last].begin(), idx);
            }
            nums.pop_back();
            return true;
        }
        return false;
    }
    
    int getRandom() {
        return nums[rand() % nums.size()];
    }
private:
    vector<int> nums;
    unordered_map<int, vector<int>> m;
};