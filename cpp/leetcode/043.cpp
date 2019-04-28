class Solution {
public:
    string multiply(string num1, string num2) {
        int m = num1.size(), n = num2.size();
        string res(m + n, '0');
        for(int i = m - 1; i>=0; i--){
            for(int j = n - 1; j>=0; j--){
                int tmp = res[i+j+1] - '0' + (num1[i] - '0') * (num2[j] - '0');
                res[i+j+1] = tmp % 10 + '0';
                res[i+j] += tmp / 10;
            }
        }
        auto idx = res.find_first_not_of('0');
        if(idx == string::npos) return "0";
        else return res.substr(idx);
    }
};