class Solution(object):
    def validUtf8(self, data):
        cnts = 0
        for num in data:
            print num, num >> 5, num >> 4, num >> 3, num >> 7
            if not cnts:
                if (num >> 5) == 0b110:
                    cnts = 1
                elif (num >> 4) == 0b1110:
                    cnts = 2
                elif (num >> 3) == 0b11110:
                    cnts = 3
                elif (num >> 7):
                    return False
            else:
                if (num >> 6) != 0b10:
                    return False
                cnts -= 1
        return cnts == 0