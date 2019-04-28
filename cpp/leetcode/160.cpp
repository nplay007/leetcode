class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if(!headA || !headB) return NULL;
        ListNode *pa = headA, *pb = headB;
        while(pa != pb){
            pa = !pa? headB: pa->next;
            pb = !pb? headA: pb->next;
        }
        return pa;
    }
};