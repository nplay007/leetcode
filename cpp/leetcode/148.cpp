class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if(!head || !head->next) return head;
        ListNode *fast = head->next, *slow = head;
        while(fast && fast->next){
            fast = fast->next->next;
            slow = slow->next;
        }
        ListNode* nhead = slow->next;
        slow->next = NULL;
        fast = sortList(nhead);
        slow = sortList(head);
        ListNode *dummy = new ListNode(0);
        head = dummy;
        while(slow && fast){
            if(fast->val < slow->val) {head->next = fast; fast = fast->next;}
            else {head->next = slow; slow = slow->next;}
            head = head->next;
        }
        if(fast || slow) head->next = fast ? fast : slow;
        return dummy->next;
    }
};