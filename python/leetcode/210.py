class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        from collections import deque
        graph = { i:set() for i in range(numCourses)} # v:income number
        neigh = [set() for i in range(numCourses)] # graph
        res, cnts = [], 0
        for [x, y] in prerequisites:
            graph[x].add(y)
            neigh[y].add(x) 
        queue = deque([i for i in graph if not graph[i]])
        while queue:
            v = queue.popleft()
            res.append(v)
            cnts += 1
            for node in neigh[v]:
                graph[node].remove(v)
                if not graph[node]: queue.append(node)
        return res if cnts == numCourses else []

# DFS
class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        graph = [set() for i in range(numCourses)]
        visit = [0 for i in range(numCourses)]
        res = []
        for x, y in prerequisites:
            graph[y].add(x)
        for i in range(numCourses):
            if not self.dfs(i, graph, visit, res): return []
        return res[::-1]
    
    def dfs(self, i, graph, visit, res):
        if visit[i] == 1: return True
        if visit[i] == -1: return False
        visit[i] = -1
        for j in graph[i]:
            if not self.dfs(j, graph, visit, res): return False
        visit[i] = 1
        res.append(i)
        return True