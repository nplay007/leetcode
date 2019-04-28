class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* ptr = head;
        while (ptr) {
            while(ptr->next && ptr->val == ptr->next->val) 
                ptr->next = ptr->next->next;
            ptr = ptr->next;
        }
        return head;
    }
};