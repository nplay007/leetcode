def numberOfArithmeticSlices(self, A):
    dp, i = [0,0], 1
    for j in xrange(2,len(A)):
        if A[j]-A[j-1] == A[j-1]-A[j-2]:
            dp.append(opt[j-1]+i)
            i += 1
        else:
            dp.append(opt[j-1])
            i = 1
    return dp[-1]