class Solution(object):
    def reconstructQueue(self, people):
        if not people: return []
        people = sorted(people, key=lambda x: (-x[0], x[1]))
        res = []
        for p in people:
            res.insert(p[1], p)
        return res