public class BandMatrix {

    public static void main(String[] args) {
        // Parse the first command line argument as the size of the matrix (n)
        int n = Integer.parseInt(args[0]);
        // Parse the second command line argument as the width of the band
        int width = Integer.parseInt(args[1]);

        // Loop through each row of the matrix
        for (int i = 0; i < n; i++) {
            // Loop through each column of the matrix
            for (int j = 0; j < n; j++) {
                // Check if the absolute difference between column and row indices (distance from main diagonal)
                // is greater than the width
                if (Math.abs(j - i) > width) {
                    // Print "0" if the element is outside the band
                    System.out.print("0" + "  ");
                } else {
                    // Print "*" if the element is within the band
                    System.out.print("*" + "  ");
                }
            }
            // Move to the next line after printing all columns of the current row
            System.out.println();
        }
    }
}