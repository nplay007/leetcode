class ZigzagIterator {
private:
    queue<pair<vector<int>::iterator, vector<int>::iterator>> data;

public:
    ZigzagIterator(vector<int> &v1, vector<int> &v2) {
        if (!v1.empty()) {
            data.push(make_pair(v1.begin(), v1.end()));
        }
        if (!v2.empty()) {
            data.push(make_pair(v2.begin(), v2.end()));
        }
    }

    int next() {
        auto node = data.front();
        data.pop();
        if (node.first + 1 != node.second) {
            data.push(make_pair(node.first + 1, node.second));
        }
        return *(node.first);
    }

    bool hasNext() {
        return !data.empty();
    }
};