string simplifyPath(string path) {
    string res, ch;
    vector<string> stk;
    stringstream ss(path);
    while(getline(ss, ch, '/')) {
        if (ch == "" or ch == ".") continue;
        if (ch == ".." and !stk.empty()) stk.pop_back();
        else if (ch != "..") stk.push_back(ch);
    }
    for(auto str : stk) res += "/"+str;
    return res.empty() ? "/" : res;
}