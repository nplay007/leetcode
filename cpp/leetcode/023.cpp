class Solution {
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        if (lists.empty()) {
            return nullptr;
        }
        while (lists.size() > 1) {
            lists.push_back(mergeTwoLists(lists[0], lists[1]));
            lists.erase(lists.begin());
            lists.erase(lists.begin());
        }
        return lists.front();
    }

    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        if (!l1 || !l2) {
            return l1 ? l1 : l2;
        }
        if (l1->val <= l2->val) {
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        } else {
            l2->next = mergeTwoLists(l1, l2->next);
            return l2;
        }
    }
}

struct cmp {
    bool operator()(ListNode *a, ListNode *b) { return a->val > b->val; }
};

class Solution {
  public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        priority_queue<ListNode *, vector<ListNode *>, cmp> pq;
        for (auto list : lists) {
            if (list){
                pq.push(list);
            }
        }
        ListNode *dummy = new ListNode(0);
        ListNode *ptr = dummy;
        while (!pq.empty()) {
            auto node = pq.top();
            pq.pop();
            ptr->next = node;
            ptr = ptr->next;
            if (node->next) {
                pq.push(node->next);
            }
        }
        return dummy->next;
    }
};