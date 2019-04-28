class Solution(object):
    def levelOrderBottom(self, root):
        res = []
        self.help(0, root, res)
        res.reverse()
        return res

    def help(self, level, root, res):
        if not root: return
        if len(res) < level + 1: res.append([])
        res[level].append(root.val)
        self.help(level + 1, root.left, res)
        self.help(level + 1, root.right, res)