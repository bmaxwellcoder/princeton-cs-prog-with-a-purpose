public class GeneralizedHarmonic {

    public static void main(String[] args) {
        // Parse the first command line argument as the nth number
        int nthNum = Integer.parseInt(args[0]);
        // Parse the second command line argument as the r order
        int rOrder = Integer.parseInt(args[1]);

        // Initialize the generalized harmonic number to 0.0
        double genHarmonicNum = 0.0;
        for(int i = 1; i <= nthNum; i++) {
            // Add the i-th term of the generalized harmonic series to the sum
            genHarmonicNum += 1 / Math.pow(i, rOrder);
        }

        // Print the calculated generalized harmonic number
        System.out.println(genHarmonicNum);
    }
}
