class Solution(object):
    def countComponents(self, n, edges):
        res = n
        temp = range(n)  # help list, 用于连接集合和查找index
        for edge in edges:
            if self.unite(edge[0], edge[1], temp):
                res -= 1
        return res

    def unite(self, start, end, temp):
        sid = self.find(start, temp)
        eid = self.find(end, temp)
        if sid == eid:  return False
        else:  # 不同id，连接成一个集合
            temp[sid] = eid
            return True

    def find(self, start, temp):
        while temp[start] != start:  # 假如不相同，意味着start已经被归入了集合
            temp[start] = temp[temp[start]]  # 往下深入，寻找最终的id
            start = temp[start]  #
        return start


class Solution(object):
    def countComponents(self, n, edges):
        visited = [0] * n  # [0, 0, 0, 0]
        dic = {x: [] for x in xrange(n)}  # {0: [], 1: [], 2: [], 3: []}
        for edge in edges:
            dic[edge[0]].append(edge[1])
            dic[edge[1]].append(edge[0])
        res = 0
        for i in xrange(n):
            if not visited[i]:  # 入口，visit 所有相关的id
                self.dfs_helper(i, dic, visited)
                res += 1
        return res

    def dfs_helper(self, i, dic, visited):
        if visited[i]: return
        visited[i] = 1
        for j in dic[i]:  self.dfs_helper(j, dic, visited)
        # 注意keys的id从0开始。 # 把id为i的所有关联id全部visited一遍


class Solution(object):
    def countComponents(self, n, edges):
        visited = [0] * n  # [0, 0, 0, 0]
        dic = {x: [] for x in xrange(n)}  # {0: [], 1: [], 2: [], 3: []}
        for edge in edges:
            dic[edge[0]].append(edge[1])
            dic[edge[1]].append(edge[0])
        res = 0
        for i in xrange(n):
            if not visited[i]:  # 入口，visit所有相关的id
                res, touched = res + 1, [i]
                while touched:
                    node = touched.pop(0)
                    if not visited[node]:
                        visited[node] = 1
                        for j in dic[node]:
                            touched.append(j)  
        return res