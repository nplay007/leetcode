class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head || !head->next) return head;
        ListNode* dummy = new ListNode(0);
        ListNode *fast = head, *slow = dummy;
        slow->next = fast;
        while(fast){
            while(fast->next && fast->val = fast->next->val){
                fast = fast->next;
            }
            if(slow->next != fast) slow->next = fast->next;
            else slow = slow->next;
            fast = fast->next;
        }
    }
};


class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(!head || !head->next) return head;
        ListNode *dummy = new ListNode(0);
        ListNode* ptr = dummy;
        dummy->next = head;
        while(ptr){
            ListNode *cur = ptr->next;
            while(cur && cur->next && cur->val == cur->next->val) cur = cur->next;
            if(ptr->next != cur) ptr->next = cur->next;
            else ptr = ptr->next;
        }
        return dummy->next;
    }
};