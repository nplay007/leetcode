class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        RandomListNode *ptr = head;
        while(ptr){
            RandomListNode * node = new RandomListNode(ptr->label);
            node->next = ptr->next;
            ptr->next = node;
            ptr = ptr->next->next;
        }
        for(ptr = head; ptr; ptr = ptr->next->next){
            if(ptr->random) ptr->next->random = ptr->random->next;
        }
        RandomListNode *nhead = new RandomListNode(0);
        RandomListNode *copy = nhead;
        for(ptr = head; ptr; ){
            copy->next = ptr->next;
            ptr->next = ptr->next->next;
            ptr = ptr->next;
            copy = copy->next;
        }
        return nhead->next;
    }
};