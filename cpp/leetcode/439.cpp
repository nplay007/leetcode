class Solution {
public:
    string parseTernary(string& expression, int begin = 0) {
        if (begin >= expression.size()) return "";
        if (begin == expression.size() - 1 || expression[begin + 1] == ':') return expression.substr(begin, 1);
        if (expression[begin] == 'T') return parseTernary(expression, begin + 2);
        int level = 1, i = begin + 2;
        for (; i < expression.size() && level; i++) {
            if (expression[i] == '?') level++;
            else if (expression[i] == ':') level--;
        }
        return parseTernary(expression, i);
    }
};