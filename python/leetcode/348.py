class TicTacToe(object):
    def __init__(self, n):
        count = collections.Counter()

    def move(self, row, col, player):
        for i, x in enumerate((row, col, row+col, row-col)):
                count[i, x, player] += 1
                if count[i, x, player] == n:
                    return player
        return 0