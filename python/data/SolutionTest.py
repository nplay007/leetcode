import unittest


class Solution(object):
    def twoSum(self, nums, target):
        sums = {}
        for idx, num in enumerate(nums):
            if target - num in sums:
                return [sums[target - num], idx]
            sums[num] = idx
        raise ValueError("Can't find answer for the input")


class SolutionTest(unittest.TestCase):
    def test(self):
        s = Solution()
        self.assertEqual(s.twoSum([1, 2, 3, 4], 5), [1, 2])


if __name__ == "__main__":
    unittest.main()