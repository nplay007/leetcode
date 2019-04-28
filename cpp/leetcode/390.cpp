class Solution {
public:
    int lastRemaining(int n) {
        bool left = true;
        int remain = n;
        int step = 1;
        int head = 1;
        while(remain > 1){
            if(left || remain % 2 == 1){
                head = head + step;
            }
            remain /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
};