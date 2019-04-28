//recrusive
class Solution {
  public:
    ListNode *swapPairs(ListNode *head) {
        if (!head || !head->next) {
            return head;
        }
        ListNode* nhead = head->next;
        head->next = swapPairs(head->next->next);
        nhead->next = head;
        return nhead;
    }
};

//iterative
class Solution {
  public:
    ListNode *swapPairs(ListNode *head) {
        ListNode *dummy = new ListNode(0), *ptr = dummy;
        dummy->next = head;
        while (ptr->next && ptr->next->next) {
            ListNode *tmp = ptr->next->next;
            ptr->next->next = tmp->next;
            tmp->next = ptr->next;
            ptr->next = tmp;
            ptr = tmp->next;
        }
        return dummy->next;
    }
};