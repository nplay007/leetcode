from collections import Counter
def findAnagrams(self, s, p):
    res = []
    pCounter = Counter(p)
    sCounter = Counter(s[:len(p)-1])
    for i in range(len(p)-1,len(s)):
        sCounter[s[i]] += 1   # include a new char in the window
        if sCounter == pCounter:
            res.append(i-len(p)+1)   # append the starting index
        sCounter[s[i-len(p)+1]] -= 1   # decrease the count of oldest char in the window
        if sCounter[s[i-len(p)+1]] == 0:
            del sCounter[s[i-len(p)+1]]   # remove the count if it is 0
    return res
