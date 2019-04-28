class StringIterator {
  public:
    StringIterator(string compressedString) {
        is = istringstream(compressedString);
        cnt = 0;
        c = ' ';
    }

    char next() {
        if (hasNext()) {
            --cnt;
            return c;
        }
        return ' ';
    }

    bool hasNext() {
        if (cnt == 0) {
            is >> c >> cnt;
        }
        return cnt > 0;
    }

  private:
    istringstream is;
    int cnt;
    char c;
};

class StringIterator {
  public:
    StringIterator(string compressedString) {
        istringstream is(compressedString);
        int cnt = 0;
        char c = ' ';
        while (is >> c >> cnt) {
            q.push({c, cnt});
        }
    }

    char next() {
        if (hasNext()) {
            auto &t = q.front();
            if (--t.second == 0) {
                q.pop();
            }
            return t.first;
        }
        return ' ';
    }

    bool hasNext() {
        return !q.empty();
    }

  private:
    queue<pair<char, int>> q;
};