class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        if (!head) {
            return head;
        }
        ListNode *dummy = new ListNode(0);
        ListNode *ptr = head, *pre = dummy;
        while (ptr) {
            ListNode *next = ptr->next;
            while (pre->next && pre->next->val < ptr->val) {
                pre = pre->next;
            }
            ptr->next = pre->next;
            pre->next = ptr;
            pre = dummy;
            ptr = next;
        }
        return dummy->next;
    }
};