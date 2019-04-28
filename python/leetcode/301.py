class Solution(object):
    def removeInvalidParentheses(self, s):
        from collections import deque
        visited = set([s])
        ans, queue, flag = [], deque([s]), False
        while queue:
            node = queue.popleft()
            if self.isValid(node):
                flag = True
                ans.append(node)
            if flag: continue 
            for i in range(len(node)):
                if node[i] not in ('(',')'): continue 
                newnode = node[:i] + node[i+1:]
                if newnode not in visited:
                    visited.add(newnode)
                    queue.append(newnode)
        return ans 

    def isValid(self, s):
        cnts = 0
        for ch in s:
            cnts += {'(':1, ')':-1}.get(ch, 0)
            if cnts < 0: return False
        return cnts == 0

class Solution(object):
    def dfs(self, s, visited):
        miss = self.calc(s)
        if miss == 0: return [s]
        ans = []
        for i in range(len(s)):
            if s[i] in ['(', ')']:
                ns = s[:i] + s[i+1:]
                if ns not in visited and self.calc(ns) < miss:
                    visited.add(ns)
                    ans.extend(self.dfs(ns, visited))
        return ans 

    def calc(self, s):
        a, b = 0, 0
        for ch in s:
            a += {'(' : 1, ')' : -1}.get(ch, 0)
            b += a < 0 # a > 0: 0; a < 0: 1
            a = max(a, 0)
        return a + b

    def removeInvalidParentheses(self, s):
        visited = set([s])
        return self.dfs(s, visited)