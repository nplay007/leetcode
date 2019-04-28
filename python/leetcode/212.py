class Solution(object):
    def findWords(self, board, words):
        root = {}
        for word in words:
            node = root
            for ch in word:
                if ch not in node:
                    node[ch] = {}
                node = node[ch]  # child
            node['#'] = '#'  # end
        res = []
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.find(board, i, j, root, '', res)
        return list(set(res))

    def find(self, board, i, j, root, path, res):
        if '#' in root: res.append(path)
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] not in root:
            return
        tmp, board[i][j] = board[i][j], "@"
        self.find(board, i + 1, j, root[tmp], path + tmp, res)
        self.find(board, i, j + 1, root[tmp], path + tmp, res)
        self.find(board, i - 1, j, root[tmp], path + tmp, res)
        self.find(board, i, j - 1, root[tmp], path + tmp, res)
        board[i][j] = tmp