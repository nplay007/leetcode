class Solution:
    # @return a string
    def countAndSay(self, n):
        i = 0
        string = '1'
        while i < n-1:
            strnew =''
            count = 0
            for j in range(len(string)):
                if j < len(string)-1 and string[j] == string[j+1]:
                    j += 1
                    count += 1
                else:
                    count += 1
                    s = str(count)+string[j]
                    strnew += s
                    count = 0
                    j += 1
            string = strnew
            i += 1
        return string

if __name__ == '__main__':
    A = Solution()
    print len(A.countAndSay(31))