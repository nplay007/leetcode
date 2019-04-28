class Solution(object):
    def simplifyPath(self, path):
        strs = path.split("/")
        res = []
        for ch in strs:
            if not ch or ch == '.': continue
            if ch == '..' and len(res) > 0: res.pop()
            elif ch != '..': res.append(ch)
        return "/" + "/".join(res)