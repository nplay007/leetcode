class Solution:
    def longestConsecutive(self, root):
        if not root: return 0
        return self.help(root, 0, root.val - 1)

    def help(self, root, length, preVal):
        if not root: return length
        cur = 1 if preval + 1 != root.val else length + 1
        return max(cur, max(self.help(root.left, cur, root.val), self.help(root.right, cur, root.val)))
