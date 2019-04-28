import unittest
from answer import Solution001


class Solution001Test(unittest.TestCase):
    solution = Solution001.Solution()

    def setUp(self):
        pass

    def test_empty(self):
        self.assertEqual(self.solution.twoSum([1, 2, 4, 7], 9), [1, 3])


if __name__ == '__main__':
    unittest.main()