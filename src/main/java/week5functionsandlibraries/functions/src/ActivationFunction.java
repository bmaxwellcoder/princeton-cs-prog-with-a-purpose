/**
 * ActivationFunction implements various activation functions used in neural
 * networks.
 * These functions map real numbers into specific ranges (like [0,1] or [-1,1])
 * and are crucial for introducing non-linearity into neural networks.
 */
public class ActivationFunction {
    /**
     * Returns the Heaviside step function of x.
     * The Heaviside function is a discontinuous function that returns:
     * - 0 for negative values
     * - 0.5 for x = 0
     * - 1 for positive values
     * 
     * @param x the input value
     * @return H(x) = {0 if x < 0, 0.5 if x = 0, 1 if x > 0}
     */
    public static double heaviside(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }

        // Handle infinity and maximum values
        // if (x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE) {
        // return 1.0;
        // }
        // if (x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE) {
        // return 0.0;
        // }

        if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        if (x == Double.NEGATIVE_INFINITY) {
            return 0.0;
        }

        if (x < 0) {
            return 0.0;
        } else if (x == 0) {
            return 0.5;
        } else {
            return 1;
        }
    }

    /**
     * Returns the sigmoid function of x.
     * The sigmoid function maps any real number into the range (0,1).
     * It's commonly used in neural networks as it provides smooth gradients.
     * 
     * @param x the input value
     * @return σ(x) = 1 / (1 + e^(-x))
     */
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }

        // Handle infinity and maximum values
        // if (x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE) {
        // return 1.0;
        // }
        // if (x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE) {
        // return 0.0;
        // }

        if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        if (x == Double.NEGATIVE_INFINITY) {
            return 0.0;
        }

        // For very small values, sigmoid(x) ≈ 0.5 + x/4
        if (Math.abs(x) < Double.MIN_NORMAL) {
            return 0.5 + x / 4;
        }

        return 1 / (1 + Math.pow(Math.E, -x));
    }

    /**
     * Returns the hyperbolic tangent function of x.
     * The tanh function maps any real number into the range (-1,1).
     * It's similar to sigmoid but centered at 0.
     * 
     * @param x the input value
     * @return tanh(x) = (e^x - e^(-x)) / (e^x + e^(-x))
     */
    public static double tanh(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }

        // Handle special cases
        if (x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE) {
            return 1.0;
        }
        if (x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE) {
            return -1.0;
        }

        // For very small values, tanh(x) ≈ x
        if (Math.abs(x) < Double.MIN_NORMAL) {
            return x;
        }

        // Regular calculation for normal values
        return (Math.pow(Math.E, x) - Math.pow(Math.E, -x))
                / (Math.pow(Math.E, x) + Math.pow(Math.E, -x));
    }

    /**
     * Returns the softsign function of x.
     * The softsign function maps any real number into the range (-1,1).
     * It's similar to tanh but has slower asymptotic behavior.
     * 
     * @param x the input value
     * @return f(x) = x / (1 + |x|)
     */
    public static double softsign(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }

        // Handle infinity and maximum values
        // if (x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE) {
        // return 1.0;
        // }
        // if (x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE) {
        // return -1.0;
        // }
        if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        if (x == Double.NEGATIVE_INFINITY) {
            return -1.0;
        }

        // For very small values, softsign(x) ≈ x
        if (Math.abs(x) < Double.MIN_NORMAL) {
            return x;
        }

        return x / (1 + Math.abs(x));
    }

    /**
     * Returns the square nonlinearity function of x.
     * The SQNL function is a piecewise function that provides
     * smooth transitions between linear and constant regions.
     * 
     * @param x the input value
     * @return SQNL(x) = {
     *         -1 if x ≤ -2,
     *         x + x²/4 if -2 < x < 0,
     *         x - x²/4 if 0 ≤ x < 2,
     *         1 if x ≥ 2
     *         }
     */
    public static double sqnl(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }

        // Handle infinity and maximum values
        // if (x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE) {
        // return 1.0;
        // }
        // if (x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE) {
        // return -1.0;
        // }
        if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        if (x == Double.NEGATIVE_INFINITY) {
            return -1.0;
        }

        // For very small values, sqnl(x) ≈ x
        if (Math.abs(x) < Double.MIN_NORMAL) {
            return x;
        }

        if (x <= -2) {
            return -1;
        } else if ((x > -2) && (x < 0)) {
            return x + (Math.pow(x, 2) / 4);
        } else if ((x >= 0) && (x < 2)) {
            return x - (Math.pow(x, 2) / 4);
        } else {
            return 1;
        }
    }

    /**
     * Takes a double command-line argument x and prints each activation
     * function, evaluated, in the format (and order) given below.
     * 
     * @param args command-line arguments containing the input value x
     */
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("tanh(" + x + ") = " + tanh(x));
        System.out.println("softsign(" + x + ") = " + softsign(x));
        System.out.println("sqnl(" + x + ") = " + sqnl(x));
    }
}
