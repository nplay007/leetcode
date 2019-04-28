class Solution(object):  
    def canWin(self, s):  
        for i in range(len(s) - 1):  # try all possible ways
            if s[i:i+2] == "++":   
                current = s[0:i] + "--" + s[i+2:]
                if not self.canWin(current):  # if other people can win, then you win
                    return True
        return False  # no possible solution

