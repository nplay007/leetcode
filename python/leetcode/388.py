class Solution(object):
    def lengthLongestPath(self, input):
        res, path = 0, {0: 0}
        for line in input.splitlines(): # '\n''
            name = line.lstrip('\t')
            depth = len(line) - len(name)
            if '.' in name:
                res = max(res, path[depth] + len(name))
            else:
                path[depth + 1] = path[depth] + len(name) + 1
        return res