class Solution {
public:
    void reorderList(ListNode* head) {
        if(!head || !head->next) return;
        ListNode* fast = head->next, *slow = head;
        while(fast && fast->next){
         fast = fast->next->next;
         slow = slow ->next;
        }
        fast = slow->next;
        slow->next = NULL;
        ListNode* nhead = NULL;//null
        while(fast){
            ListNode* tmp = fast->next;
            fast->next = nhead;
            nhead = fast;
            fast = tmp;
        }
        for(slow = head, fast = nhead; slow;){
            ListNode* tmp = slow->next;
            slow->next=fast;
            slow = fast;
            fast = tmp;
        }
    }
};