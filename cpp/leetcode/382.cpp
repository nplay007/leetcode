class Solution {
public:
    Solution(ListNode *head) {
        nhead = head;
    }

    int getRandom() {
        int cnts = 0, res = 0;
        ListNode *ptr = nhead;
        while (ptr) {
            cnts++;
            int j = rand() % cnts;
            if (j == 0) {
                res = ptr->val;
            }
            ptr = ptr->next;
        }
        return res;
    }

  private:
    ListNode *nhead;
};