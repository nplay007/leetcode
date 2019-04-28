class Solution(object):
    def getHint(self, secret, guess):
        bull, cow, num = 0, 0, [0] * 10
        for ch1, ch2 in zip(secret, guess):
            if ch1 == ch2:
                bull += 1
                continue
            num1, num2 = int(ch1), int(ch2)
            if num[num1] < 0: cow += 1
            if num[num2] > 0: cow += 1
            num[num1] += 1
            num[num2] -= 1
        return str(bull) + 'A' + str(cow) + 'B'