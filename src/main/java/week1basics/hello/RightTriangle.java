package week1basics.hello;

/**
 * This program determines whether three integer values can form a right
 * triangle.
 * It checks if the sides satisfy the Pythagorean theorem (a² + b² = c²) for any
 * arrangement of the sides.
 * 
 * Usage: java RightTriangle <side1> <side2> <side3>
 * where all values are positive integers
 * 
 * @author Bryan Williamson
 */
public class RightTriangle {

        /**
         * Main method that checks if three given sides can form a right triangle.
         * 
         * @param args Command line arguments:
         *             args[0]: length of first side
         *             args[1]: length of second side
         *             args[2]: length of third side
         */
        public static void main(String[] args) {
                // Parse command-line arguments for the lengths of the triangle's sides
                int side1 = Integer.parseInt(args[0]);
                int side2 = Integer.parseInt(args[1]);
                int side3 = Integer.parseInt(args[2]);

                // Check if all sides are positive (a requirement for a valid triangle)
                boolean allPositive = (side1 > 0) && (side2 > 0) && (side3 > 0);

                // Check if the sides form a right triangle using the Pythagorean theorem
                // We need to check all three possible arrangements since we don't know which is
                // the hypotenuse
                boolean isPythagoreanWith3asHypotenuse = (side1 * side1 + side2 * side2 == side3 * side3);
                boolean isPythagoreanWith2asHypotenuse = (side1 * side1 + side3 * side3 == side2 * side2);
                boolean isPythagoreanWith1asHypotenuse = (side2 * side2 + side3 * side3 == side1 * side1);

                // Triangle is a right triangle if all sides are positive and at least one
                // arrangement satisfies the theorem
                boolean isRightTriangle = allPositive &&
                                (isPythagoreanWith1asHypotenuse ||
                                                isPythagoreanWith2asHypotenuse ||
                                                isPythagoreanWith3asHypotenuse);

                // Print the result
                System.out.println(isRightTriangle);

                // Another option to determine if the triangle is a right triangle
                /*
                 * isRightTriangle = (sideOne > 0) && (sideTwo > 0) && (sideThree > 0) &&
                 * ((sideOne * sideOne + sideTwo * sideTwo) ==
                 * (sideThree * sideThree)
                 * || (sideOne * sideOne + sideThree * sideThree) ==
                 * (sideTwo * sideTwo)
                 * || (sideThree * sideThree + sideTwo * sideTwo) ==
                 * (sideOne * sideOne));
                 */
        }
}
