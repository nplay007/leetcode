class Solution {
public:
    int evalRPN(vector<string> &tokens) {
        stack<int> res;
        for (string item : tokens) {
            if (item == "+" || item == "-" || item == "*" || item == "/") {
                int n1 = res.top();
                res.pop();
                int n2 = res.top();
                res.pop();
                if (item == "+") {
                    res.push(n2 + n1);
                } else if (item == "-") {
                    res.push(n2 - n1);
                } else if (item == "*") {
                    res.push(n2 * n1);
                } else if (item == "/") {
                    res.push(n2 / n1);
                }
            } else {
                res.push(stoi(item));
            }
        }
        return res.top();
    }
};