class Solution {  
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode* nhead = new ListNode(0);
        nhead->next = head;
        ListNode* ptr = nhead;
        for (int i = 0; i < m - 1; i++) ptr = ptr -> next;
        ListNode* start = ptr -> next;
        for (int i = 0; i < n - m; i++) {
            ListNode* end = start -> next; 
            start -> next = end -> next;
            end -> next = ptr -> next;
            ptr -> next = end;
        }
        return nhead -> next;
    }
};