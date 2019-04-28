class Solution {
public:
    string getHint(string secret, string guess) {
        unordered_map<char, int> smap;
        unordered_map<char, int> gmap;
        int n = secret.size();
        int A = 0, B = 0;
        for (int i = 0; i < n; i++) {
            char s = secret[i], g = guess[i];
            if (s == g) A++;
            else {
                (smap[g] > 0) ? smap[g]--, B++ : gmap[g]++;
                (gmap[s] > 0) ? gmap[s]--, B++ : smap[s]++; 
            }
        }
        return to_string(A) + "A" + to_string(B) + "B";;
    }         
};


class Solution {
public:
    string getHint(string secret, string guess) {
        int na = 0, nb = 0;
        int num[10] = {0};
        for(int i = 0; i < secret.size(); ++i){
            if(secret[i] == guess[i]) {
                na++;
            } else {
                int sIdx = secret[i] - '0';
                int gIdx = guess[i] - '0';
                if(num[sIdx] < 0) nb++;
                if(num[gIdx] > 0) nb++;
                num[sIdx]++; num[gIdx]--;
            }
        }
        return to_string(na) + "A" + to_string(nb) + "B";
    }
};