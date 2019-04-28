class BSTIterator:
    def __init__(self, root):
        self.stack = []
        self.pushAll(root)

    def hasNext(self):
        return self.stack

    def next(self):
        node = self.stack.pop()
        self.pushAll(node.right)
        return node.val
        
    def pushAll(self, node):
        while node is not None:
            self.stack.append(node)
            node = node.left