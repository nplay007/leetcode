int longestSubstring(string s, int k){
    return help(s, 0, s.size(), k);
}

int help(string str, int start, int end, int k){
    if(end < start) return 0;
    if(end - start < k) return 0;
    int count[26] = {0};
    for(int i = start; i < end; ++i){
        int idx = str[i] - 'a';
        count[idx]++;
    }
    for(int i = 0; i < 26; ++i){
        if(count[i] == 0) continue;
        if(count[i] < k ) {
            for(int j = start; j < end; ++j){
                if(str[j] == i + 'a'){
                    int left = help(str, start, j, k);
                    int right = help(str, j+1, end, k);
                    return max(left, right);
                }
            }
        }
    }
    return end - start;
}