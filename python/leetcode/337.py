class Solution(object):
    def rob(self, root):
        res = self.robSub(root)
        return max(res[0], res[1])

    def robSub(self, root):
        if not root:
            return [0, 0]
        left = self.robSub(root.left)
        right = self.robSub(root.right)
        res = [0, 0]
        res[0] = max(left[0], left[1]) + max(right[0], right[1])
        res[1] = root.val + left[0] + right[0]
        return res
