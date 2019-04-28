package JavaAnswer.seven;

class StringIterator {
    String str;
    int idx; // idx of string
    int num; // num of count
    char ch; // char

    public StringIterator(String s) {
        str = s;
        idx = 0;
        num = 0;
        ch = ' ';
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        if (num == 0) {
            ch = str.charAt(idx++);
            while (idx < str.length() && Character.isDigit(str.charAt(idx))) {
                num = num * 10 + str.charAt(idx++) - '0';
            }
        }
        num--;
        return ch;
    }

    public boolean hasNext() {
        return idx != str.length() || num != 0;
    }
}