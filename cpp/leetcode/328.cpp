class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if(!head || !head->next) return head;
        ListNode* h1 = new ListNode(0);
        ListNode* h2 = new ListNode(0);
        ListNode* odd = h1;
        ListNode* even = h2;
        while(head){
            odd->next = head;
            even->next = head->next;
            odd = odd->next;
            even = even->next;
            head = head->next? head->next->next: NULL;
        }
        odd->next = h2->next;
        return h1->next;
    }
};