class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if (!l1 || !l2) {
            return l1 ? l1 : l2;
        }
        ListNode* dummy = new ListNode(0);
        ListNode* ptr = dummy;
        int carry = 0;
        while (l1 || l2 || carry) {
            int val1 = l1 ? l1->val : 0;
            int val2 = l2 ? l2->val : 0;
            int sum = carry + val1 + val2;
            ptr->next = new ListNode(sum % 10);
            ptr = ptr->next;
            carry = sum / 10;
            l1 = l1 ? l1->next : NULL;
            l2 = l2 ? l2->next : NULL;
        }
        return dummy->next;
    }
};