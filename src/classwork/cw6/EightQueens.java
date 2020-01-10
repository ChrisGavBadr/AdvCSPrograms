package classwork.cw6;

public class EightQueens {
    private final static int QUEENS = 8;

    // Print solution
    public void printSolution(int[][] board) {
        for (int i = 0; i < QUEENS; i++) {
            for (int j = 0; j < QUEENS; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    // Check for attacking queens
    public boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Left row check
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Upper-left diagonal check
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Lower-left diagonal check
        for (i = row, j = col; j >= 0 && i < QUEENS; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private boolean solveQueens(int[][] board, int col) {
        for (int i = 0; i < QUEENS; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (col < QUEENS - 1) {
                    if (solveQueens(board, col + 1)) {
                        return true;
                    } else {
                        board[i][col] = 0;
                    }
                } else {
                    printSolution(board);
                    return true;
                }
            }
        }

        return false;
    }

    // Initialize 8x8 board
    public boolean solveNQ(int[][] board) {
        if (!solveQueens(board, 0)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    // Main Function
    public static void main(String[] args) {
        int[][] board = new int[QUEENS][QUEENS];

        /* int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0}}; */

        EightQueens queen = new EightQueens();
        queen.solveNQ(board);
    }
}
