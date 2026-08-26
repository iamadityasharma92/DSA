import java.util.Scanner;

public class N_Queens_branch_bounds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        int n=4;
        int[][] board=new int[n][n];
        int[] cols= new int[n];
        int[] ndiags= new int[2*n-1];
        int[] rdiags= new int [2*n-1];
        solution(board,0,"",cols,ndiags,rdiags);
//        sc.close();
    }
    static void solution(int[][] board,int row,String asf,int[] cols, int[] ndiags,int[] rdiags) {
        if(row==board.length){
            System.out.println(asf+".");
            return;
        }

        for(int col=0;col<board.length;col++){
            if(board[row][col]==0 && cols[col]==0 && ndiags[row+col]==0&&rdiags[row-col+board.length-1]==0) {
                board[row][col] = 1;
                cols[col] = 1;
                ndiags[row + col] = 1;
                rdiags[row - col + board.length - 1] = 1;
                solution(board, row + 1, asf + row + "-" + col+" ,", cols, ndiags, rdiags);
                board[row][col] = 0;
                cols[col] = 0;
                ndiags[row + col] = 0;
                rdiags[row - col + board.length - 1] = 0;
            }
        }

    }
}

