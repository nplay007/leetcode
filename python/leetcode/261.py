class Solution(object):
    def validTree(self, n, edges):
        root = [i for i in range(n)]
        for edge in edges:
            root1 = self.find(root, edge[0])
            root2 = self.find(root, edge[1])
            if root1 == root2: return False
            else: root[root1] = root2
        return len(edges) == n - 1

    def find(self, root, node):
        if root[node] == node: return node
        else: return self.find(root, root[node])  