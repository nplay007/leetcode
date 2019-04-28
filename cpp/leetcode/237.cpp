class Solution {
public:
    void deleteNode(ListNode* node) {
        ListNode* p = node->next;
        node->next = p->next;
        node->val = p->val;
    }
};
