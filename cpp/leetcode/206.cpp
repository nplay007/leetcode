class Solution {
public:
    ListNode *reverseList(ListNode *head) {
        if (!head || !head->next) {
            return head;
        }
        ListNode *nhead = NULL;
        while (head) {
            ListNode *tmp = head->next;
            head->next = nhead;
            nhead = head;
            head = tmp;
        }
        return nhead;
    }
};

class Solution {
public:
    ListNode *reverseList(ListNode *head) {
        if (!head || !head->next) {
            return head;
        }
        ListNode *nhead = reverseList(head->next);
        head->next->next = head;
        head->next = NULL; // set the end of list to null
        return nhead;
    }
};