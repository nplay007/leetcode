class RandomizedSet {
public:
    RandomizedSet() {}
    
    bool insert(int val) {
        if(m.find(val) == m.end()){
            nums.push_back(val);
            m[val] = nums.size() - 1;
            return true;
        }
        return false;
    }
    
    bool remove(int val) {
        if(m.find(val) != m.end()){
            int idx = m[val];
            int last = nums.back();
            m[last] = idx;
            nums[idx] = last;
            nums.pop_back();
            m.erase(val);
            return true;
        }
        return false;
    }
    
    int getRandom() {
        return nums[rand() % nums.size()];
    }
private:
    vector<int> nums;
    unordered_map<int, int> m;
};