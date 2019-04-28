class Solution:
    def diffWaysToCompute(self, input):
        if input.isdigit(): return [int(input)]
        res = []
        for i in xrange(len(input)):
            if input[i] in "-+*":
                res1 = self.diffWaysToCompute(input[:i])
                res2 = self.diffWaysToCompute(input[i + 1:])
                for left in res1:
                    for right in res2:
                        if input[i] == "+": res.append(left + right)
                        elif input[i] == "-": res.append(left - right)
                        else: res.append(left * right)
        return res