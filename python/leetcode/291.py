def wordPatternMatch(self, pattern, str):
    return self.dfs(pattern, str, {})

def dfs(self, pattern, str, word):
    if len(pattern) == 0 and len(str) > 0: return False
    if len(pattern) == 0 and len(str) == 0: return True
    for i in range(1, len(str) - len(pattern) + 2):
        # len(str[i:]) >= len(pattern) - 1; len(str) - i >= len(pattern) - 1
        # i <= len(str) - len(pattern) + 1; i < len(str) - len(pattern) + 2
        if pattern[0] not in word and str[:i] not in word.values():
            word[pattern[0]] = str[:i]
            if self.dfs(pattern[1:], str[i:], word): return True
            del word[pattern[0]] # not possible soultion, del 
        elif pattern[0] in word and word[pattern[0]] == str[:i]:
            if self.dfs(pattern[1:], str[i:], word): return True
    return False