class NumArray(object):
    def __init__(self, nums):
        self.dp = [0] * (len(nums) + 1) # C[i]
        self.n = len(nums)   # n is used for add
        self.nums = nums  # a[i], it will be update many times
        for i in range(len(nums)):
            self.add(i+1, nums[i]) # start from 1
    
    def add(self, x, val):
        while x <= self.n:  # equal, for i start from 1
            self.dp[x] += val
            x += self.lowbit(x)
    
    def lowbit(self, x):
        return x & -x
        
    def sum(self, x):
        res = 0
        while x > 0:
            res += self.dp[x]
            x -= self.lowbit(x)
        return res 
        
    def update(self, i, val):
        self.add(i+1, val - self.nums[i]) # add the difference to i+1
        self.nums[i] = val # update a[i]

    def sumRange(self, i, j):
        if not self.nums: return 0
        return self.sum(j+1) - self.sum(i)

import math
class NumArray(object):  # segment Tree
    def __init__(self, nums):
        self.nums = nums
        self.size = size = len(nums)
        h = int(math.ceil(math.log(size, 2))) if size else 0
        maxSize = 2 ** (h + 1) - 1
        self.st = [0] * maxSize
        if size:
            self.initST(0, size - 1, 0)

    def update(self, i, val):
        if i < 0 or i >= self.size:
            return
        diff = val - self.nums[i]
        self.nums[i] = val
        self.updateST(0, self.size - 1, i, diff, 0)

    def sumRange(self, i, j):
        if i < 0 or j < 0 or i >= self.size or j >= self.size:
            return 0
        return self.sumRangeST(0, self.size - 1, i, j, 0)

    def initST(self, ss, se, si):
        if ss == se:
            self.st[si] = self.nums[ss]
        else:
            mid = (ss + se) / 2
            self.st[si] = self.initST(ss, mid, si * 2 + 1) + \
                          self.initST(mid + 1, se, si * 2 + 2)
        return self.st[si]

    def updateST(self, ss, se, i, diff, si):
        if i < ss or i > se:
            return
        self.st[si] += diff
        if ss != se:
            mid = (ss + se) / 2
            self.updateST(ss, mid, i, diff, si * 2 + 1)
            self.updateST(mid + 1, se, i, diff, si * 2 + 2)

    def sumRangeST(self, ss, se, qs, qe, si):
        if qs <= ss and qe >= se:
            return self.st[si]
        if se < qs or ss > qe:
            return 0
        mid = (ss + se) / 2
        return self.sumRangeST(ss, mid, qs, qe, si * 2 + 1) + \
                self.sumRangeST(mid + 1, se, qs, qe, si * 2 + 2)




## method 3
class Node(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
        self.total = 0
        self.left = None
        self.right = None

class NumArray(object):
    def __init__(self, nums):
        # helper function to create the tree from input array
        def createTree(nums, l, r):
            # base case
            if l > r:
                return None
            # leaf node
            if l == r:
                n = Node(l, r)
                n.total = nums[l]
                return n
            mid = (l + r) // 2
            root = Node(l, r)
            # recursively build the Segment tree
            root.left = createTree(nums, l, mid)
            root.right = createTree(nums, mid + 1, r)
            # Total stores the sum of all leaves under root
            # i.e. those elements lying between (start, end)
            root.total = root.left.total + root.right.total
            return root
        self.root = createTree(nums, 0, len(nums) - 1)

    def update(self, i, val):
        # Helper function to update a value
        def updateVal(root, i, val):
            # Base case. The actual value will be updated in a leaf.
            # The total is then propogated upwards
            if root.start == root.end:
                root.total = val
                return val
            mid = (root.start + root.end) // 2
            # If the index is less than the mid, that leaf must be in the left subtree
            if i <= mid:
                updateVal(root.left, i, val)
            # Otherwise, the right subtree
            else:
                updateVal(root.right, i, val)
            # Propogate the changes after recursive call returns
            root.total = root.left.total + root.right.total
            return root.total
        return updateVal(self.root, i, val)

    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """

        # Helper function to calculate range sum
        def rangeSum(root, i, j):
            # If the range exactly matches the root, we already have the sum
            if root.start == i and root.end == j:
                return root.total
            mid = (root.start + root.end) // 2
            # If end of the range is less than the mid, the entire interval lies
            # in the left subtree
            if j <= mid:
                return rangeSum(root.left, i, j)
            # If start of the interval is greater than mid, the entire inteval lies
            # in the right subtree
            elif i >= mid + 1:
                return rangeSum(root.right, i, j)
            # Otherwise, the interval is split. So we calculate the sum recursively,
            # by splitting the interval
            else:
                return rangeSum(root.left, i, mid) + rangeSum(root.right, mid + 1, j)
        return rangeSum(self.root, i, j)