class Solution {
public:
    int reverse(int x) {
        long valOfReverse = 0;
        while (x) {
            valOfReverse = 10 * valOfReverse + x % 10;
            x /= 10;
        }
        if (valOfReverse > INT_MAX || valOfReverse < INT_MIN) {
            return 0;
        }
        return (int) valOfReverse;
    }
};