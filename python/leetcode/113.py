class Solution(object):
        if not root: return [] 
        res = []
        self.help(root, [], res, sum)
        return res
    
    def help(self, root, ans, res, target):
        if not root: return 
        if not root.left and not root.right and target == root.val:
            ans.append(root.val)
            res.append(ans)
        self.help(root.left, ans + [root.val], res, target - root.val)
        self.help(root.right, ans + [root.val], res, target - root.val)