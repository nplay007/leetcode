class Solution {
public:
    bool validUtf8(vector<int>& data) {
        int cnts = 0;
        for(auto num : data){
            if(cnts == 0){
                if((num >> 5) == 0b110) cnts = 1;
                else if((num >> 4) == 0b1110) cnts = 2;
                else if((num >> 3) == 0b11110) cnts = 3;
                else if((num >> 7)) return false;
            } else {
                if((num >> 6) != 0b10) return false;
                cnts --;
            }
        }
        return cnts == 0;
    }
};