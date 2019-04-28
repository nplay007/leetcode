class Solution(object):
    def generateTrees(self, n):
        if n == 0:
            return []
        return self.dfs(1, n)

    def dfs(self, start, end):
        if start > end:
            return [None]
        res = []
        for idx in range(start, end + 1):
            leftnodes = self.dfs(start, idx - 1)
            rightnodes = self.dfs(idx + 1, end)
            for left in leftnodes:
                for right in rightnodes:
                    root = TreeNode(val)
                    root.left = left
                    root.right = right
                    res.append(root)
        return res
