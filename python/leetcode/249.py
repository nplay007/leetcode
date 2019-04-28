class Solution(object):
    def groupStrings(self, strings):
        d = collections.defaultdict(list)
        strings.sort()
        for word in strings:
            shift = [chr((ord(ch) - ord(word[0])) % 26) for ch in word]
            shift = "".join(shift) if shift else " "
            d[shift].append(word)
        return d.values()