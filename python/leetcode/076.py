import collections
class Solution:
    def minWindow(self, s, t):
        need, missing = collections.Counter(t), len(t)
        i, l, r = 0, 0, 0
        for idx, val in enumerate(s, 1):
            missing -= need[val] > 0  # need[val] <= 0, will get false == 0
            need[val] -= 1
            if not missing:
                while i < idx and need[s[i]] < 0:
                    need[s[i]] += 1
                    i += 1
                if not r or idx - i <= r - l:
                    l, r = i, idx
            print need, missing, l, r
        return s[l:r]


if __name__ == "__main__":
    test = Solution()
    print test.minWindow("ADOBECODEBANC", "ABC")