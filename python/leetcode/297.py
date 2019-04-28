class Solution:
    def serialize(self, root):
        def help(node):
            if node:
                vals.append(str(node.val))
                help(node.left)
                help(node.right)
            else:
                vals.append('#')
        vals = []
        help(root)
        return ' '.join(vals)

    def deserialize(self, data):
        def help():
            val = next(vals)
            if val == '#': return None
            node = TreeNode(int(val))
            node.left = help()
            node.right = help()
            return node
        vals = iter(data.split())
        return help()