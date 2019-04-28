class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if(!head || !head->next) return true;
        ListNode* fast = head->next, *slow = head;
        while(fast && fast->next){
            fast = fast->next->next;
            slow = slow->next;
        }
        fast = slow->next;
        slow->next = NULL;
        ListNode* nhead = NULL;
        while(fast){
            ListNode* tmp = fast->next;
            fast->next = nhead;
            nhead = fast;
            fast = tmp;
        }
        for(fast = nhead, slow = head; slow && fast; ){
            if(fast->val != slow->val) return false;
            fast = fast->next;
            slow = slow->next;
        }
        return true;
    }
};