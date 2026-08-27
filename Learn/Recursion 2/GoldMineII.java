public class GoldMineII {

    public static void main(String[] args) {
        int[][] grid = {
                {10, 0, 100, 200, 0, 8, 0},
                {20, 0, 0, 0, 0, 6, 0},
                {30, 0, 0, 9, 12, 3, 4},
                {40, 0, 2, 5, 8, 3, 11},
                {0, 0, 0, 0, 0, 9, 0},
                {5, 6, 7, 0, 7, 4, 2},
                {8, 9, 10, 0, 1, 10, 8}
        };

//        int[][] grid = {
//                {0, 6, 0},
//                {5, 8, 7},
//                {0, 9, 0}
//        };


        System.out.println("Maximum Gold Collected: " + getMaxGold(grid));
    }

    public static int getMaxGold(int[][] grid) {
        int maxGold = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0 && visited[i][j] == false) {
                    int currentGold = collectGoldDFS(grid, i, j,visited);
                    maxGold = Math.max(maxGold, currentGold);
                }
            }
        }
        return maxGold;
    }

    private static int collectGoldDFS(int[][] grid, int r, int c, boolean[][] visited) {
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]==0||visited[r][c])
        return 0;

        visited[r][c] = true;
        int totalGold= grid[r][c];
        totalGold+=collectGoldDFS(grid, r + 1, c, visited);
        totalGold+=collectGoldDFS(grid, r - 1, c, visited);
        totalGold+=collectGoldDFS(grid, r, c + 1, visited);
        totalGold+=collectGoldDFS(grid, r, c - 1, visited);
        return totalGold;
    }
}
