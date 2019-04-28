package JavaAnswer.four;

class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diag;
    private int adiag;
    private int size;

    public TicTacToe(int n) {
        size = n;
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        adiag = 0;
    }

    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        rows[row] += add;
        cols[col] += add;
        diag += (row == col ? add : 0);
        adiag += (row + col == size - 1 ? add : 0);
        return (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diag) == size || Math.abs(adiag) == size) ? player : 0;
    }
}