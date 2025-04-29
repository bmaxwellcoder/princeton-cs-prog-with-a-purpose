/**
 * Divisors implements various functions related to number theory and
 * divisibility.
 * This includes computing greatest common divisors, least common multiples,
 * checking for relative primality, and calculating Euler's totient function.
 */
public class Divisors {
    /**
     * Returns the greatest common divisor of a and b.
     * The gcd is the largest positive integer that divides both a and b.
     * For example, gcd(1440, 408) = 24 because:
     * - 24 is a divisor of both 1440 (1440 = 24 * 60) and 408 (408 = 24 * 17)
     * - No larger integer divides both numbers
     * 
     * Uses Euclidean algorithm which states that gcd(a,b) = gcd(b,r) where r is the
     * remainder of a divided by b. For example, for gcd(1440,408):
     * 1. 1440 = 3 * 408 + 216 (so gcd(1440,408) = gcd(408,216))
     * 2. 408 = 1 * 216 + 192 (so gcd(408,216) = gcd(216,192))
     * 3. 216 = 1 * 192 + 24 (so gcd(216,192) = gcd(192,24))
     * 4. 192 = 8 * 24 + 0 (since remainder is 0, 24 is the gcd)
     * 
     * @param a the first number
     * @param b the second number
     * @return gcd(a,b) - the greatest common divisor of a and b
     */
    public static int gcd(int a, int b) {
        // Handle special cases
        if (a == 0 && b == 0) {
            return 0;
        }

        if (b == 0) {
            return Math.abs(a);
        }

        // Work with absolute values
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        // Use Euclidean algorithm:
        // 1. If absA is divisible by absB, then absB is the GCD
        // 2. Otherwise, replace absA with absB and absB with remainder of absA/absB
        // 3. Repeat until we find a number that divides evenly (remainder = 0)
        while (absA % absB != 0) { // Continue while remainder is not 0
            int temp = absA; // Save original absA
            absA = absB; // New absA is old absB
            absB = temp % absB; // New absB is remainder of old absA/absB
        }

        return absB; // When remainder is 0, absB is the GCD
    }

    /**
     * Returns the least common multiple of a and b.
     * The lcm is the smallest positive integer that is a multiple of both a and b.
     * For example, lcm(56, 96) = 672 because:
     * - 672 is a multiple of both 56 (672 = 56 * 12) and 96 (672 = 96 * 7)
     * - No smaller positive number is a multiple of both
     * 
     * @param a the first number
     * @param b the second number
     * @return lcm(a,b) - the least common multiple of a and b
     */
    public static int lcm(int a, int b) {
        // Handle special case where either number is 0
        if (a == 0 || b == 0) {
            return 0;
        }

        // Work with absolute values
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        // Use the relationship: lcm(a,b) = |a*b| / gcd(a,b)
        return (absA * absB) / gcd(a, b);
    }

    /**
     * Returns true if a and b are relatively prime, false otherwise.
     * Two integers are relatively prime if they share no positive common divisors
     * other than 1. For example, 221 and 384 are not relatively prime because
     * 17 is a common divisor.
     * 
     * @param a the first number
     * @param b the second number
     * @return true if a and b are relatively prime, false otherwise
     */
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    /**
     * Returns the number of integers between 1 and n that are relatively prime with
     * n.
     * This is known as Euler's totient function φ(n).
     * For example, φ(9) = 6 because the six numbers 1, 2, 4, 5, 7, and 8
     * are relatively prime with 9.
     * 
     * @param n the input number
     * @return φ(n) - the number of integers between 1 and n that are relatively
     *         prime with n
     */
    public static int totient(int n) {
        // Handle non-positive input
        if (n <= 0) {
            return 0;
        }

        // Count numbers that are relatively prime with n
        int primeCount = 0;
        for (int i = 0; i < n; i++) {
            if (areRelativelyPrime(n, (i + 1))) {
                primeCount++;
            }
        }

        return primeCount;
    }

    /**
     * Takes two integer command-line arguments a and b and prints each function,
     * evaluated, in the format (and order) given below.
     * 
     * @param args command-line arguments containing the input values a and b
     */
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out.println("areRelativelyPrime(" + a + ", " + b + ") = "
                + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + b + ") = " + totient(b));
    }
}
