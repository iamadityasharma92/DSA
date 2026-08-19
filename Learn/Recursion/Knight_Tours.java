import java.util.Scanner;

public class Knight_Tours {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = 8;
        int[][] chess = new int[n][n];

        KTours(chess, 0,0,1);

//        sc.close();
    }

    public static void KTours(int[][] chess, int r,int c, int move) {
        if(r<0||c<0||r>=chess.length||c>=chess.length||chess[r][c]>0){
            return;
        }else if(move==chess.length*chess.length){
            chess[r][c]=move;
            displayBoard(chess);
            chess[r][c]=0;
            return;
        }

        chess[r][c]=move;// put move no. in chess
        KTours(chess,r-2,c+1,move+1);
        KTours(chess,r-1,c+2,move+1);
        KTours(chess,r+1,c+2,move+1);
        KTours(chess,r+2,c+1,move+1);
        KTours(chess,r+2,c-1,move+1);
        KTours(chess,r+1,c-2,move+1);
        KTours(chess,r-1,c-2,move+1);
        KTours(chess,r-2,c-1,move+1);
        chess[r][c]=0;// backtrack

    }

    public static void displayBoard(int[][] chess){
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess.length;j++){
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
