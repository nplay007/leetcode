class Queue {
public:
    void push(int x) {
        if(stk.empty()) {stk.push(x); return;}
        int num = stk.top(); stk.pop();
        push(x);
        stk.push(num);
    }

    void pop(void) {
        stk.pop();
    }

    int peek(void) {
        return stk.top();
    }

    bool empty(void) {
        return stk.empty();
    }
private:
    stack<int> stk;
};