class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        n = len(gas)
        start, total, tank = 0, 0, 0
        for i in xrange(n):
            tank += gas[i] - cost[i]
            if tank < 0:
                start = i+1
                total += tank
                tank = 0
        if total + tank < 0: return -1
        else: return start