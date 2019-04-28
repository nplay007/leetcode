class Solution(object):
    def closestKValues(self, root, target, k):
        from heapq import heappush, heappop
        h, res = [], []
        self.dfs(root, target, h)
        for i in range(k):
            res.append(heappop(h)[1])
        return res
        
    def dfs(self, root, target, h):
        from heapq import heappush, heappop    
        if not root: return
        self.dfs(root.left, target, h)
        heappush(h, (abs(root.val - target), root.val))
        self.dfs(root.right, target, h)

class Solution:
    def closestKValues(self, root, target, k):
        res, s1, s2 = [], [], []
        self.inorder(root, target, False, s1)
        self.inorder(root, target, True,  s2)
        # all num in s1 <= target, all num in s2 > target 
        while k > 0:
            if not s1:
                res.append(s2[-1])
                s2.pop()
            elif not s2:
                res.append(s1[-1])
                s1.pop()
            elif abs(s1[-1] - target) < abs(s2[-1] - target):
                res.append(s1[-1])
                s1.pop()
            else:
                res.append(s2[-1])
                s2.pop()
            k -= 1
        return res

    def inorder(self, root, target, flag, stk):
        if not root: return 
        self.inorder(root.right if flag else root.left, target, flag, stk)
        if (flag and root.val <= target) or (not flag and root.val > target): return
        stk.push(root.val)
        self.inorder(root.left if flag else root.right, target, flag, stk)