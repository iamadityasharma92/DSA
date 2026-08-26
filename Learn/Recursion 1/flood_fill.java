import java.util.Scanner;

public class flood_fill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] maze = {
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 0}
        };

//        int[][] maze = {
//                {0, 1, 0},
//                {0, 0, 0},
//                {1, 0, 0}
//        };


        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        floodfill(maze, 0, 0, "", visited);
    }

    // Updated recursive function signature for Flood Fill matrix traversal
    static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited) {
        if(row==maze.length-1 && col==maze[0].length-1){
            System.out.println(psf+",");
            return;
        }
        if(row<0 || col<0 || row>maze.length-1 || col>maze[0].length-1 || maze[row][col]==1|| visited[row][col]==true){
            return;
        }

        visited[row][col]=true;
        floodfill(maze,row-1,col,psf+"t",visited);
        floodfill(maze,row,col-1,psf+"l",visited);
        floodfill(maze,row+1,col,psf+"d",visited);
        floodfill(maze,row,col+1,psf+"r",visited);
        visited[row][col]=false;
    }
}
