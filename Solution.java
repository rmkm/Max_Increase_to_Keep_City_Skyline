public class Solution {

    int[] skylineBottom(int[][] grid){
        int[] skyline = new int[grid[0].length];
        for (int i = 0; i < skyline.length; i++){
            int max = 0;
            for (int j = 0; j < grid.length; j++){
                if (max < grid[j][i]){
                    max = grid[j][i];
                }
            }
            skyline[i] = max;
        }
        return skyline;
    }

    int[] skylineLeft(int[][] grid){
        int[] skyline = new int[grid.length];
        for (int i = 0; i < skyline.length; i++){
            int max = 0;
            for (int j = 0; j < grid[0].length; j++){
                if (max < grid[i][j]){
                    max = grid[i][j];
                }
            }
            skyline[i] = max;
        }
        return skyline;
    }

    int maxIncreaseKeepingSkyline(int[][] grid) {
        int maxIncrease = 0;
        int[] skylineBottom = skylineBottom(grid);
        int[] skylineLeft = skylineLeft(grid);
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (skylineLeft[i] > skylineBottom[j]){
                    maxIncrease += skylineBottom[j] - grid[i][j];
                }
                else {
                    maxIncrease +=  skylineLeft[i] - grid[i][j];
                }
            }
        }
        return maxIncrease;
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(solution.maxIncreaseKeepingSkyline(grid));
    }
}
