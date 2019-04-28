class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        if(s.empty()) return {""};
        queue<string> q;
        vector<string> res;
        q.push(s);
        unordered_set<string> myset;
        myset.insert(s);
        bool flag = false;
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < q.size(); i++){
                string tmp = q.front(); q.pop();
                if(isValid(tmp)) {
                    flag = true;
                    res.push_back(tmp);
                }
                if(flag) continue;
                for(int j = 0; j < tmp.size(); ++j){
                    if(tmp[j] == '(' || tmp[j] == ')') {
                        string newstr = tmp.substr(0, j) + tmp.substr(j+1);
                        if(myset.find(newstr) == myset.end()) {
                            myset.insert(newstr);
                            q.push(newstr);
                        }
                    }
                }
            }
        }
        return res;
    }
    
    bool isValid(string s){
        int cnts = 0;
        for(auto ch : s){
            if(ch == '(') cnts ++;
            else if(ch == ')') cnts --;
            if(cnts < 0) return false;
        }
        return cnts == 0;
    }
};


class Solution {
private:
	void dfs(string& s, int last_i, int last_j, string pair, vector<string> &res){
		int cnts = 0;
		for(int i = last_i; i < s.size(); i++){
			if(s[i] == pair[0]) cnts++;
			else if(s[i] == pair[1]) cnts--;
			if(cnts < 0){
				for(int j = last_j; j <= i; j++){
					if(s[j] == pair[1] && (j == last_j || s[j-1] != pair[1])){
						string t = s.substr(0, j) + s.substr(j+1);
						dfs(t, i, j, pair, res);
					}
				}
				return;
			}
		}
		string t = s;
		reverse(t.begin(), t.end());
		if(pair[0]=='('){
			dfs(t, 0, 0, string {')', '('}, res);
		}else{
			res.push_back(t);
		}
	}    
public:
	vector<string> removeInvalidParentheses(string s) {
		vector<string> res;
		string pair = {'(', ')'};
		dfs(s, 0, 0, pair, res);
		return res;
	}
};