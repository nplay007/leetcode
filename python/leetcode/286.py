class Solution(object):
def wallsAndGates(self, a):
    for i in range(len(a)):
        for j in range(len(a[0])):
            if a[i][j] == 0:
                stack = [(i + 1, j, 1), (i - 1, j, 1), (i, j + 1, 1), (i, j - 1, 1)]
                while stack:
                    x, y, dist = stack.pop()
                    if x < 0 or y < 0 or x >= len(a) or y >= len(a[0]) or a[x][y] < dist:
                        continue
                    a[x][y] = dist
                    stack.append((x + 1, y, dist + 1))
                    stack.append((x - 1, y, dist + 1))
                    stack.append((x, y + 1, dist + 1))
                    stack.append((x, y - 1, dist + 1))