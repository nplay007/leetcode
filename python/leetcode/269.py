class Solution:
    def alienOrder(self, words):
        less = []
        for pair in zip(words, words[1:]):
            for a, b in zip(*pair):
                if a != b:
                    less += a + b,
                    break
        chars = set(''.join(words))
        order = []
        while less:
            free = chars - set(zip(*less)[1])
            if not free: return ''
            order += free
            less = filter(free.isdisjoint, less)
            chars -= free
            print free, order, less, chars
        return ''.join(order + list(chars))

if __name__ == "__main__":
    test = Solution()
    test.alienOrder(["wrt", "wrf", "er", "ett", "rftt"])