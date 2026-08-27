class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] chess = new int[n][n];
        int[] cols= new int[n];
        int[] ndiags= new int[2*n-1];
        int[] rdiags= new int [2*n-1];
        nQueens(chess, 0, result,cols,ndiags,rdiags);
        return result;
    }

    public static void nQueens(int[][] board, int row, List<List<String>> result,int[] cols, int[] ndiags, int[] rdiags) {
        if (row == board.length) {
            result.add(constructBoard(board));
            return;
        }

        for(int col=0;col<board.length;col++){
            if(board[row][col]==0 && cols[col]==0 && ndiags[row+col]==0&&rdiags[row-col+board.length-1]==0) {
                board[row][col] = 1;
                cols[col] = 1;
                ndiags[row + col] = 1;
                rdiags[row - col + board.length - 1] = 1;
                nQueens(board, row + 1, result, cols, ndiags, rdiags);
                board[row][col] = 0;
                cols[col] = 0;
                ndiags[row + col] = 0;
                rdiags[row - col + board.length - 1] = 0;
            }
    }
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
