class Solution(object):
    def flatten(self, root):
        while root:
            if root.left:
                node = root.left
                while node.right: node = node.right
                node.right = root.right
                root.right = root.left
                root.left = None
            else: root  = root.right