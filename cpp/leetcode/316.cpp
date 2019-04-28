string removeDuplicateLetters(string s) {
    vector<int> cand(256, 0);
    vector<bool> visited(256, false);
    for (char ch : s) cand[ch]++;
    string res = "0";
    for (char ch : s) {
        cand[ch]--;
        if (visited[ch]) continue;
        while (ch < res.back() && cand[res.back()]) {
            visited[res.back()] = false;
            res.pop_back();
        }
        res += ch;
        visited[ch] = true;
    }
    return res.substr(1);
}