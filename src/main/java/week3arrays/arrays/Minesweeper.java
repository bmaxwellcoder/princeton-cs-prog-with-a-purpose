package week3arrays.arrays;

/**
 * This program creates a Minesweeper game board of size m×n with k mines
 * placed randomly. Each non-mine cell displays the number of adjacent mines.
 * 
 * Usage: java Minesweeper m n k
 * where m is the number of rows
 * n is the number of columns
 * k is the number of mines
 * 
 * @author Bryan Williamson
 */
public class Minesweeper {

    /**
     * Main method that creates and displays a Minesweeper game board.
     * 
     * @param args Command line arguments:
     *             args[0]: number of rows (m)
     *             args[1]: number of columns (n)
     *             args[2]: number of mines (k)
     */
    public static void main(String[] args) {
        // Parse command-line arguments
        int m = Integer.parseInt(args[0]); // Number of rows
        int n = Integer.parseInt(args[1]); // Number of columns
        int k = Integer.parseInt(args[2]); // Number of mines

        // Create the mine field
        boolean[][] hasMineArr = new boolean[m][n];

        // Place k mines randomly on the board
        int remainingMines = k;
        while (remainingMines > 0) {
            int x = (int) (Math.random() * m);
            int y = (int) (Math.random() * n);

            // Only place a mine if the position doesn't already have one
            if (!hasMineArr[x][y]) {
                hasMineArr[x][y] = true;
                remainingMines--;
            }
        }

        // Calculate number of adjacent mines for each cell
        int[][] neighboringMineArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Count mines in all 8 adjacent cells
                int mineCount = 0;

                // Check 8 surrounding positions
                for (int iDelta = -1; iDelta <= 1; iDelta++) {
                    for (int jDelta = -1; jDelta <= 1; jDelta++) {
                        // Skip the current cell
                        if (iDelta == 0 && jDelta == 0) {
                            continue;
                        }

                        // Calculate adjacent position
                        int iAdj = i + iDelta;
                        int jAdj = j + jDelta;

                        // Check if position is valid and has a mine
                        if (iAdj >= 0 && iAdj < m && jAdj >= 0 && jAdj < n && hasMineArr[iAdj][jAdj]) {
                            mineCount++;
                        }
                    }
                }

                neighboringMineArr[i][j] = mineCount;
            }
        }

        // Display the Minesweeper board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (hasMineArr[i][j]) {
                    System.out.print("*  "); // Display mines as asterisks
                } else {
                    System.out.print(neighboringMineArr[i][j] + "  "); // Display count of adjacent mines
                }
            }
            System.out.println(); // End each row with a newline
        }
    }
}
