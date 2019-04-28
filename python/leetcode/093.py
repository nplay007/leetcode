class Solution:
    def restoreIpAddresses(self, s):
        n, res = len(s), []
        for i in range(1, min(4, n-2)):  
            for j in range(i+1, min(i+4, n-1)):  
                for k in range(j+1, min(j+4, n)):  
                    s1, s2 = s[0:i], s[i:j]   
                    s3, s4 = s[j:k], s[k:n]   
                    if self.isValid(s1) and self.isValid(s2) and \
                       self.isValid(s3) and self.isValid(s4):
                        res.append(s1+"."+s2+"."+s3+"."+s4)
        return res

    def isValid(self, s):
        if int(s) <= 255 and str(int(s)) == s: return True
        return False