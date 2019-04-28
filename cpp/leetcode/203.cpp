class Solution {
  public:
    ListNode *removeElements(ListNode *head, int val) {
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        ListNode *ptr = dummy;
        while (ptr->next) {
            if (ptr->next->val == val) {
                ptr->next = ptr->next->next;
            } else {
                ptr = ptr->next;
            }
        }
        return dummy->next;
    }
};