class Solution {
public:
    int compareVersion(string version1, string version2) {
        istringstream s1(version1), s2(version2);
        string v1, v2;
        while(true){
            int n1 = getline(s1, v1, '.') ? stoi(v1): 0;
            int n2 = getline(s2, v2, '.') ? stoi(v2): 0;
            if (n1 < n2) return -1;
            else if(n1 > n2) return 1;
            else if(!s1 && !s2) return 0;
        }
    }
};

class Solution {
public:
    int compareVersion(string version1, string version2) {
        int n = version1.size(), m = version2.size();
        int  i = 0, j = 0;
        while(i < n || j < m){
            int v1 = 0, v2 = 0;
            while(i < n && version1[i] != '.') {
                v1 = v1 * 10 + (version1[i] - '0');
                i++;
            }
            while(j < m && version2[j] != '.'){
                v2 = 10 * v2 + (version2[j] - '0');
                j++;
            }
            if(v1 > v2) return 1;
            else if (v1 < v2) return -1;
            i++; j++;
        }
        return 0;
    }
};