class Solution {
  public:
    ListNode *reverseKGroup(ListNode *head, int k) {
        if (!head || k == 0) {
            return head;
        }
        int n = 0;
        for (ListNode *ptr = head; ptr; ptr = ptr->next) {
            ++n;
        }
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        ptr = dummy;
        while (n >= k) {
            ListNode *tail = ptr->next;
            for (int i = 0; i < k - 1; i++) {
                ListNode *tmp = tail->next;
                tail->next = tmp->next;
                tmp->next = ptr->next;
                ptr->next = tmp;
            }
            ptr = tail;
            n -= k;
        }
        return dummy->next;
    }
};