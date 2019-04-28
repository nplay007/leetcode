class Solution:
    def fractionToDecimal(self, numerator, denominator):
        n, r = divmod(abs(numerator), abs(denominator))
        sign = '-' if numerator*denominator < 0 else ''
        res = [sign + str(n), '.']
        stack = []
        while r not in stack:
            stack.append(r)
            n, r = divmod(r*10, abs(denominator))
            res.append(str(n))
        idx = stack.index(r)
        print res, stack, r, idx
        res.insert(idx + 2, '(')
        res.append(')')
        return ''.join(res).replace('(0)', '').rstrip('.')

if __name__ == '__main__':
    test = Solution()
    print test.fractionToDecimal(4, 333)