class Solution {
public:
    int findCelebrity(int n) {
        int x = 0;
        for(int i = 0; i < n; i++){
            if(knows(x, i)) x = i;  // knows(a, b) <==> b > a
        } 
        for(int i = 0; i < x; i++){ // number after x has compared before
            if(knows(x, i)) return -1; // everyone knows x 
        }
        for(int i = 0; i < n; i++){
            if(!knows(i, x)) return -1; // x doesn't know anyone
        }
        return x;
    }
};