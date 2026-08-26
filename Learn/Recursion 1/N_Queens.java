import java.util.Scanner;

public class N_Queens {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = 4;
        int[][] chess = new int[n][n];

        nQueens(chess, "",0);

//        sc.close();
    }

    public static void nQueens(int[][] chess, String qsf,int row) {
        if(row==chess.length){
            System.out.println(qsf+".");
            return;
        }

        for(int col=0;col<chess.length;col++){
            if(isQueenSafe(chess,row,col)) {
                chess[row][col] = 1;
                nQueens(chess, row + "-" + col + "," + qsf, row + 1);
                chess[row][col] = 0;
            }
        }

    }

    public static boolean isQueenSafe(int[][] chess,int row,int col){
        //column check
        for(int i=row-1,j=col;i>=0&&j>=0;i--){
            if(chess[i][j]==1)
                return false;
        }
        // diagonal wise left side
        for(int i=row-1,j=col-1;i>=0&&j>=0;j--,i--){
            if(chess[i][j]==1)
                return false;
        }
        // diagonal wise right side
        for(int i=row-1,j=col+1;i>=0&&j<chess.length;j++,i--){
            if(chess[i][j]==1)
                return false;
        }
        return true;
    }
}
