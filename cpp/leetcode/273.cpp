class Solution {
public:
string help(int num){
    vector<string> arr1={"","One","Two","Three","Four","Five","Six",
    "Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen",
    "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    vector<string> arr2={"","","Twenty","Thirty","Forty","Fifty","Sixty",
    "Seventy","Eighty","Ninety"};
    string res;
    res = num % 100 < 20 ? arr1[num%100] : arr2[(num%100)/10]+(num%10)?" "+arr1[num%10]:"");
    if(num>99)res=arr1[num/100]+" Hundred"+(num%100?" "+res:"");
    resurn res;
}
string numberToWords(int num) {
    string res;
    vector<string> strarr={"Thousand","Million","Billion"};
    res = help(num % 1000);
    for(int i = 0; i < 3; i++){
        num /= 1000;
        res = num % 1000 ? help(num%1000) + " " + strarr[i] + " " + res:res;
    }
    while(res.back() == ' ') res.pop_back();
    return res.empty() ? "Zero" : res;
}
};
