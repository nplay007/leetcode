class Solution:
    def isNumber(self, s):
        INVALID, SPACE, SIGN, DIGIT, DOT, EXPONENT = 0, 1, 2, 3, 4, 5
        #0invalid,1space,2sign,3digit,4dot,5exponent,6num_inputs
        Table=[[-1,  0,  3,  1,  2, -1], #0 no input or just spaces
              [-1,  8, -1,  1,  4,  5],  #1 input is digits
              [-1, -1, -1,  4, -1, -1],  #2 no digits in front just Dot
              [-1, -1, -1,  1,  2, -1],  #3 sign
              [-1,  8, -1,  4, -1,  5],  #4 digits and dot in front
              [-1, -1,  6,  7, -1, -1],  #5 input 'e' or 'E'
              [-1, -1, -1,  7, -1, -1],  #6 after 'e' input sign
              [-1,  8, -1,  7, -1, -1],  #7 after 'e' input digits
              [-1,  8, -1, -1, -1, -1]]  #8 after valid input input space
        state, i = 0, 0
        while i < len(s):
            inputtype = INVALID
            if s[i]==' ': inputtype = SPACE
            elif s[i]=='-' or s[i]=='+': inputtype = SIGN
            elif s[i] in '0123456789': inputtype = DIGIT
            elif s[i]=='.': inputtype = DOT
            elif s[i]=='e' or s[i]=='E': inputtype = EXPONENT
            state = Table[state][inputtype]
            if state == -1: return False
            else: i += 1
        return state == 1 or state == 4 or state == 7 or state == 8


class Solution:
    def isNumber(self, s):
        try:
            float(s.strip())
            return True
        except:
            return False
