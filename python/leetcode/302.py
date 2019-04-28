class Soluiton:
    def minArea(self, image, x, y):
        m, n = len(image), len(image[0])
        top = self.searchRows(image, 0, x, True)
        bottom = self.searchRows(image, x + 1, m, False)
        left = self.searchColumns(image, 0, y, top, bottom, True)
        right = self.searchColumns(image, y + 1, n, top, bottom, False)
        return (right - left) * (bottom - top)

    def searchRows(self, image, i, j, opt):
        while i != j:
            m = (i + j) / 2
            if ('1' in image[m]) == opt: j = m  # j = m not m - 1
            else: i = m + 1
        return i

    def searchColumns(self, image, i, j, top, bot, opt):
        while i != j:
            m = (i + j) / 2
            if any(image[k][m]=='1' for k in xrange(top, bot))==opt: j = m
            else: i = m + 1
        return i