class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        graph = [set() for i in range(numCourses)]
        visit = [0 for i in range(numCourses)]
        for [x, y] in prerequisites: graph[y].add(x)
        for i in range(numCourses):
            if not self.dfs(i, graph, visit): return False
        return True
    
    def dfs(self, i, graph, visit):
        if visit[i] == 1: return True
        if visit[i] == -1: return False
        visit[i] = -1
        for j in graph[i]:
            if not self.dfs(j, graph, visit): return False
        visit[i] = 1
        return True