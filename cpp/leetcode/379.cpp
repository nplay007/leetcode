class PhoneDirectory {
public:
    PhoneDirectory(int maxNumbers) {
        maxNum = maxNumbers;
        for(int i = 0; i < maxNumbers; i++){
            avaliable.push(i);
        }
    }
    
    int get() {
        if(avaliable.empty()) return -1;
        int num = avaliable.front();
        avaliable.pop();
        used.insert(num);
        return num;
    }
    
    bool check(int number) {
        if(number > maxNum || number < 0) return false;
        if(used.find(number) != used.end()) return false;
        else return true;
    }
    
    void release(int number) {
        if(used.find(number) != used.end()){
            used.erase(number);
            avaliable.push(number);
        }
    }
private:
    queue<int> avaliable;
    unordered_set<int> used;
    int maxNum;
    
};
