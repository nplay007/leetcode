class Solution:
    def isPalindrome(self, s):
        ans = [i.lower() for i in s if i.isalnum()]
        return ans == ans[::-1]

    def isPalindrome(self, s):
        l, r = 0, len(s) - 1
        while l < r:
            while l < r and not s[l].isalnum():
                l += 1
            while l < r and not s[r].isalnum():
                r -= 1
            if s[l].lower() != s[r].lower():
                return False
            l += 1
            r -= 1
        return True

if __name__ == '__main__':
    A = Solution()
    print A.isPalindrome("8V8K;G;K;V;")