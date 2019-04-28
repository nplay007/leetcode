class Solution:
    def closestValue(self, root, target):
        child = root.left if target < a else root.right
        if not child: return root.val 
        chVal = self.closestValue(kid, target)
        return a if abs(root.val - target) < abs(chVal - target) else chVal