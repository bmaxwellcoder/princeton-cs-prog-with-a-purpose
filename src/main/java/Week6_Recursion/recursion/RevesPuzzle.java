package Week6_Recursion.recursion;

/**
 * This class solves Reve's puzzle, a variation of the Towers of Hanoi problem
 * with 4 poles.
 * Uses the Frame-Stewart algorithm discovered in 1941.
 * 
 * The algorithm works by:
 * 1. Finding optimal k (number of smallest discs to move first)
 * 2. Moving k smallest discs to a temporary pole
 * 3. Moving remaining n-k discs using 3-pole Hanoi
 * 4. Moving k smallest discs to destination
 * 
 * @author Bryan Williamson
 */
public class RevesPuzzle {

    /**
     * Solves the 3-pole Towers of Hanoi problem for n discs.
     * 
     * @param n       number of discs to move
     * @param k       offset for disc numbering
     * @param from    source pole
     * @param refPole temporary pole
     * @param to      destination pole
     */
    private static void hanoi(int n, int k, String from, String refPole, String to) {
        if (n == 0) {
            return;
        }

        // Move n-1 discs from source to temporary pole
        hanoi(n - 1, k, from, to, refPole);
        // Move the nth disc to destination
        System.out.println("Move disk " + (n + k) + " from " + from + " to " + to);
        // Move n-1 discs from temporary to destination pole
        hanoi(n - 1, k, refPole, from, to);
    }

    /**
     * Solves Reve's puzzle using the Frame-Stewart algorithm.
     * 
     * @param n        number of discs to move
     * @param from     source pole
     * @param refPole1 first temporary pole
     * @param refPole2 second temporary pole
     * @param to       destination pole
     */
    private static void reves(int n, String from, String refPole1, String refPole2, String to) {
        // Calculate optimal k using Frame-Stewart formula
        int k = (int) Math.round(n + 1 - Math.sqrt((2 * n) + 1));

        // Base case: single disc
        if (k == 0) {
            System.out.println("Move disc " + n + " from " + from + " to " + to);
            return;
        }

        // Step 1: Move k smallest discs to temporary pole
        reves(k, from, to, refPole2, refPole1);
        // Step 2: Move remaining n-k discs using 3-pole Hanoi
        hanoi(n - k, k, from, refPole2, to);
        // Step 3: Move k smallest discs to destination
        reves(k, refPole1, from, refPole2, to);
    }

    /**
     * Main method that solves Reve's puzzle for a given number of discs.
     * 
     * @param args Command line arguments:
     *             args[0]: number of discs (n)
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // Poles are labeled A (start), B (temporary), C (temporary), D (destination)
        reves(n, "A", "B", "C", "D");
    }
}
