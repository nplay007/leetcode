class Solution {
public:
    ListNode *partition(ListNode *head, int x) {
        ListNode dummy1(0), dummy2(0);
        ListNode *p1 = &dummy1, *p2 = &dummy2;
        while (head) {
            if (head->val < x) {
                p1->next = head;
                p1 = p1.next;
            } else {
                p2->next = head;
                p2 = p2.next;
            }
            head = head->next;
        }
        p2->next = NULL;
        p1->next = dummy2.next;
        return dummy1.next;
    }
}