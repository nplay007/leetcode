class Solution:
    def preorder(self, root, level, res):
        if root:
            if len(res) < level+1: res.append([])
            if level % 2 == 0: res[level].append(root.val)
            else: res[level].insert(0, root.val)
            self.preorder(root.left, level+1, res)
            self.preorder(root.right, level+1, res)
            
    def zigzagLevelOrder(self, root):
        res=[]
        self.preorder(root, 0, res)
        return res