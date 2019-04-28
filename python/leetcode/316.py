def removeDuplicateLetters(self, s):
    for ch in sorted(set(s)):
        suffix = s[s.index(ch):]
        if set(suffix) == set(s):
            return ch + self.removeDuplicateLetters(suffix.replace(ch, ''))
    return ''

def removeDuplicateLetters(self, s):
    res = ''
    while s:
        i = min(map(s.rindex, set(s))) # s[i:] contains all chars
        ch = min(s[:i+1]) # min char value include i, in case 'a'
        res += ch
        s = s[s.index(ch):].replace(ch, '')
    return res

