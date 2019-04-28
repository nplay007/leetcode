class Solution:
    def findMinHeightTrees(self, n, edges):
        if n == 1:
            return [0]
        graph = [set() for _ in xrange(n)]
        for i, j in edges:
            graph[i].add(j)
            graph[j].add(i)
        leaves = [i for i in xrange(n) if len(graph[i]) == 1]
        while n > 2:  # remove all leaves
            n -= len(leaves)
            new_leaves = []
            for i in leaves:
                j = graph[i].pop()
                graph[j].remove(i)
                if len(graph[j]) == 1:
                    new_leaves.append(j)
            leaves = new_leaves
        return leaves
