class Solution(object):
    def myAtoi(self, str):
        str = str.strip()
        if not str:
            return 0
        INT_MAX, INT_MIN = 2**31 - 1, -2**31
        sign, i, res = 1, 0, 0
        if str[0] in "+-":
            i += 1
            sign = 1 if str[0] == '+' else -1
        while i < len(str):
            if str[i].isdigit():
                res = 10 * res + int(str[i])
                if sign * res > INT_MAX:
                    return INT_MAX
                if sign * res < INT_MIN:
                    return INT_MIN
                i += 1
            else:
                return sign * res
        return sign * res
