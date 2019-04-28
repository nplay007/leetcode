class Solution:
    def find_repeats(self, nums, first, last, k):
        N = 0
        count = {}
        for i in range(first, last):
            count[nums[i]] = count.get(nums[i], 0) + 1
            N += 1
            if len(count) == k:
                for key in count.iterkeys():
                    count[key] -= 1
                    if count[key] == 0: del count[key]
        res = []
        for key, val in count:
            if val > N / k:
                res.append(key)

        return res

if __name__ == '__main__':
    test = Solution()


