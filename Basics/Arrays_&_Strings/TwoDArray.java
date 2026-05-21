public class TwoDArray {
    public static void main(String[] args) {

        // Declare
        int[][] matrix = new int[3][3];

        // Initialize
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Access
        System.out.println(grid[0][0]);  // 1
        System.out.println(grid[1][2]);  // 6
        System.out.println(grid[2][1]);  // 8

        // Traverse
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        // Output:
        // 1 2 3
        // 4 5 6
        // 7 8 9
    }
}