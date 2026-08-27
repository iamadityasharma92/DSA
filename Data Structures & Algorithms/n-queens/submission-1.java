class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] chess = new int[n][n];
        nQueens(chess, 0, result);
        return result;
    }

    public static void nQueens(int[][] chess, int row, List<List<String>> result) {
        if (row == chess.length) {
            result.add(constructBoard(chess));
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (isQueenSafe(chess, row, col)) {
                chess[row][col] = 1;
                nQueens(chess, row + 1, result);
                chess[row][col] = 0; // Backtrack
            }
        }
    }

    public static boolean isQueenSafe(int[][] chess, int row, int col) {
        // Column check (upwards)
        for (int i = row - 1; i >= 0; i--) {
            if (chess[i][col] == 1)
                return false;
        }
        // Diagonal left (upwards-left)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1)
                return false;
        }
        // Diagonal right (upwards-right)
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1)
                return false;
        }
        return true;
    }

    // Helper method to convert the 2D int array into the required list of strings
    private static List<String> constructBoard(int[][] chess) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j] == 1) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            board.add(sb.toString());
        }
        return board;
    }
}
