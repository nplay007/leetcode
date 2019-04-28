class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        stack<int> stk1, stk2, res;
        ListNode* ptr = NULL;
        for(ptr = l1; ptr; ptr = ptr->next) stk1.push(ptr->val);
        for(ptr = l2; ptr; ptr = ptr->next) stk2.push(ptr->val);
        int carry = 0;
        ListNode *dummy = new ListNode(0);
        ptr = dummy;
        while(!stk1.empty() || !stk2.empty() || carry > 0){
            int x = 0;
            if(!stk1.empty()) {x = stk1.top(); stk1.pop();}
            int y = 0;
            if(!stk2.empty()) {y = stk2.top(); stk2.pop();}
            res.push((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        while(!res.empty()){
            ptr->next = new ListNode(res.top());
            res.pop();
            ptr = ptr->next;
        }
        return dummy->next;
    }
};



class Solution {
public:
    int help(ListNode* l1, ListNode *l2, ListNode *ptr, int len1, int len2){
        if(!l1 || !l2) return 0;
        if(len1 == len2){
            if(l1->next) ptr->next = new ListNode(0);
            int tmp = l1->val + l2->val + help(l1->next, l2->next, ptr->next, --len1, --len2);
            ptr->val = tmp % 10;
            return tmp / 10;
        }else if(len1 > len2){
            if(l1->next) ptr->next = new ListNode(0);
            int tmp = l1->val + help(l1->next, l2, ptr->next, --len1, len2);
            ptr->val = tmp % 10;
            return tmp / 10;
        }else{
            if(l2->next) ptr->next = new ListNode(0);
            int tmp = l2->val + help(l1, l2->next, ptr->next, len1, --len2);
            ptr->val = tmp % 10;
            return tmp / 10;
        }
    }
    
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(!l1 || !l2) return l1 ? l1 : l2;
        int len1 = 0, len2 = 0;
        for(ListNode* ptr = l1; ptr; ptr = ptr->next) len1++;
        for(ListNode* ptr = l2; ptr; ptr = ptr->next) len2++;
        ListNode* nhead = new ListNode(0);
        ListNode* ptr = nhead;
        int carry = 0;
        carry = help(l1, l2, ptr, len1, len2);
        if(carry){
            ListNode* dummy = new ListNode(carry);
            dummy->next = nhead;
            return dummy;
        } else {
            return nhead;
        }
    }
};