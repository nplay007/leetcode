class Solution {
  public:
    bool isHappy(int n) {
        int fast = n, slow = n;
        do {
            slow = getSum(slow);
            fast = getSum(fast);
            fast = getSum(fast);
        } while (fast != slow);
        return slow == 1;
    }

  private:
    int getSum(int n) {
        int res = 0;
        while (n) {
            res += pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }
};