class Solution:
    def compareVersion(self, version1, version2):
        num1 = [int(v) for v in version1.split(".")]
        num2 = [int(v) for v in version2.split(".")]
        n, m = len(num1), len(num2)
        for i in range(max(n, m)):
            v1 = num1[i] if i < n else 0
            v2 = num2[i] if i < m else 0
            if v1 > v2: return 1
            elif v1 < v2: return -1
        return 0