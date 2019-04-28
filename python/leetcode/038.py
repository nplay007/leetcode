class Solution(object):
    def cntsAndSay(self, n):
        if n <= 0:
            return ""
        res = '1'
        for i in range(1, n):
            tmp, cnts = '', 0
            for j in range(len(res)):
                if j < len(res) - 1 and res[j] == res[j + 1]:
                    cnts += 1
                else:
                    cnts += 1
                    tmp += str(cnts) + res[j]
                    cnts = 0
            res = tmp
        return res
