class Solution:
    def isValidBST(self, root):
        return self.help(root, float("-inf"), float("inf"))
    
    def help(self, root, min, max):
        if not root: return True
        if root.val <= min or root.val >= max: return False
        return self.help(root.left, min, root.val) and self.help(root.right, root.val, max)