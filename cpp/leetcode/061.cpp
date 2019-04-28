class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        if (!head || k == 0) {
            return head;
        }
        int cnts = 0;
        for (ListNode *fast = head; fast; fast = fast->next) {
            cnts++;
        }
        k %= cnts;
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        ListNode *fast = dummy, *slow = dummy;
        for (int i = 0; i < k; i++) {
            fast = fast->next;
        }
        for (; fast->next; fast = fast->next, slow = slow->next) ;
        fast->next = head;
        head = slow->next;
        slow->next = NULL;
        return head;
    }
};