class Solution:
    # @return a string

    def getPermutation(self, n, k):
        res = ''
        k -= 1
        factorial = 1
        for i in range(1, n):
            factorial *= i
        num = [0,1, 2, 3, 4, 5, 6, 7, 8, 9]
        for i in reversed(range(n)):
            curr = num[k/factorial]
            res += str(curr)
            num.remove(curr)
            if i != 0:
                k %= factorial
                factorial /= i
        return res

if __name__ == '__main__':
    A = Solution()
    print 9*8*7*4*3*2*1*5*6
    print A.getPermutation(10,1000000)