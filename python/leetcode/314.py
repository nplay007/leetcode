class TreeNode():
    def __init__(self, val):
        self.val = val
        self.right = None
        self.left = None

class Solution:
    def verticalOrder(self, root):
        if not root: return []
        nodes = collections.defaultdict(list)
        queues = [(root, 0)]
        for node, col in queues:
            if node:
                nodes[col].append(node.val)
                queues.append((node.left, col - 1))
                queues.append((node.right, col + 1))
        return [nodes[col] for col in sorted(nodes)]